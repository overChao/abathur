package com.crodi.algorithm.graph;

import com.alibaba.fastjson2.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class StaticGraph {
    private final int vertex;

    private int edge;


    // 端点：用以标识结束
    // TODO  zhangkc 2025/7/21: 优化端点实现
    @Getter
    @Setter
    private List<String> endpoints;

    private final Map<String, List<String>> adjMap;

    public StaticGraph(int vertex) {
        this.vertex = vertex;
        this.edge = 0;
        this.adjMap = Maps.newConcurrentMap();
    }


    public void addEdge(String source, String target) {
        // 无当前节点
        if (!adjMap.containsKey(source)) {
            adjMap.put(source, Lists.newArrayList(target));
        } else {
            adj(source).add(target);
        }
        edge++;
    }

    public List<String> adj(String v) {
        return adjMap.get(v);
    }

    //获取有向图的取反
    public StaticGraph reverse() {
        StaticGraph R = new StaticGraph(vertex);
        adjMap.keySet()
                .forEach(v -> adj(v)
                        .forEach(vertex -> R.addEdge(vertex, v)));
        return R;
    }


    /**
     * 寻路（给定端点）
     *
     * @return 点集
     */
    public List<List<String>> routePlanning(List<String> endpoints) {
        List<List<String>> routes = Lists.newArrayList();
        endpoints.forEach(point -> dfs(point, Maps.newConcurrentMap(), Lists.newArrayList(), routes));
        return routes;
    }


    /**
     * dfs 实现
     *
     * @param v       当前点
     * @param visited 访问点集
     * @param route   点位路径
     * @param routes  全量路径
     */
    private void dfs(String v, Map<String, Boolean> visited, List<String> route, List<List<String>> routes) {
        visited.put(v, Boolean.TRUE);
        route.add(v);
        if (endpoints.contains(v) && route.size() > 1) {
            routes.add(Lists.newArrayList(route));
            return;
        }
        adj(v).stream()
                .filter(w -> !visited.getOrDefault(w, Boolean.FALSE))
                .forEachOrdered(w -> {
                    dfs(w, visited, route, routes);
                    // 路径回溯
                    route.remove(route.size() - 1);
                    // 访问节点回溯
                    visited.remove(w);
                });
    }

    /**
     * 计算最短路径
     *
     * @param source 起点
     * @param target 目标点
     * @return 路径点集
     */
    public List<String> shortestRoute(String source, String target) {
        if (Objects.equals(source, target)) {
            return null;
        }
        return bfs(source, target);
    }

    private List<String> bfs(String vertex, String target) {

        Map<String, Boolean> visited = Maps.newConcurrentMap();

        // 点位关系 先序
        Map<String, String> preVertexMap = Maps.newConcurrentMap();

        // 遍历队列  FIFO
        Queue<String> queue = Queues.newArrayDeque();

        queue.offer(vertex);
        visited.put(vertex, Boolean.TRUE);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (Objects.equals(current, target)) {
                return reconstructRoute(preVertexMap, target);
            }
            adj(current).stream()
                    .filter(w -> !visited.getOrDefault(w, Boolean.FALSE))
                    .forEachOrdered(w -> {
                        preVertexMap.put(w, current);
                        visited.put(w, Boolean.TRUE);
                        queue.offer(w);
                    });
        }
        return null;
    }


    /**
     * 构建路径
     *
     * @param prev   点位关系
     * @param target 目标点
     * @return 路径点集
     */
    // TODO  crodi.zhang  2025/7/22: 优化点位关系实现 点位先序遍历
    private List<String> reconstructRoute(Map<String, String> prev, String target) {

        List<String> route = Lists.newArrayList();

        String current = target;
        while (Objects.nonNull(current)) {
            route.add(current);
            current = prev.get(current);
        }
        Collections.reverse(route);
        return route;
    }

    // 1001: [1009]
    // 1002: [1010]
    // 1003: [1011]
    // 1004: [1012]

    // 1009: [1001,R1]
    // 1010: [1002,R2]
    // 1011: [1003,R3]
    // 1012: [1004,R4]

    // R1: [1009,R2]
    // R2: [1010,R3,1018,R1]
    // R3: [1011,R4,1019,R2]
    // R4: [1012,R3]

    // 1017: [R1]
    // 1018: [1026]
    // 1019: [1027]
    // 1020: [R4]

    // 1025: [1017]
    // 1026: [S1]
    // 1027: [S2]
    // 1028: [1020]

    // S1: [1025]
    // S2: [1028]


    // [
    //  [1001,1009,1018,1026,1],
    //  [1001,1009,1019,1027,2],
    //  [1002,1010,1018,1026,1],
    //  [1002,1010,1019,1027,2],
    //  [1003,1011,1018,1026,1],
    //  [1003,1011,1019,1027,2],
    //  [1004,1012,1018,1026,1],
    //  [1004,1012,1019,1027,2],
    //
    //  [1,1025,1017,1009,1001],
    //  [1,1025,1017,1009,1019,1027,2],
    //  [1,1025,1017,1010,1002],
    //  [1,1025,1017,1011,1003],
    //  [1,1025,1017,1012,1004],
    //  [2,1028,1020,1009,1001],
    //  [2,1028,1020,1009,1018,1026,1],
    //  [2,1028,1020,1010,1002],
    //  [2,1028,1020,1011,1003],
    //  [2,1028,1020,1012,1004]
    // ]

    // [
    //  [1001,1009,1018,1026,1],
    //  [1001,1009,1019,1027,2],
    //  [1002,1010,1018,1026,1],
    //  [1002,1010,1019,1027,2],
    //  [1003,1011,1018,1026,1],
    //  [1003,1011,1019,1027,2],
    //  [1004,1012,1018,1026,1],
    //  [1004,1012,1019,1027,2],
    //  [1,1025,1017,1009,1001],
    //  [1,1025,1017,1009,1019,1027,2],
    //  [1,1025,1017,1010,1002],
    //  [1,1025,1017,1010,1019,1027,2],
    //  [1,1025,1017,1011,1003],
    //  [1,1025,1017,1011,1019,1027,2],
    //  [1,1025,1017,1012,1004],
    //  [1,1025,1017,1012,1019,1027,2],
    //  [2,1028,1020,1009,1001],
    //  [2,1028,1020,1009,1018,1026,1],
    //  [2,1028,1020,1010,1002],
    //  [2,1028,1020,1010,1018,1026,1],
    //  [2,1028,1020,1011,1003],
    //  [2,1028,1020,1011,1018,1026,1],
    //  [2,1028,1020,1012,1004],
    //  [2,1028,1020,1012,1018,1026,1]
    // ]


    public static void main(String[] args) {
        StaticGraph graph = new StaticGraph(22);
        // 库前接驳区
        graph.addEdge("1001", "1009");
        graph.addEdge("1002", "1010");
        graph.addEdge("1003", "1011");
        graph.addEdge("1004", "1012");

        graph.addEdge("1009", "1001");
        graph.addEdge("1010", "1002");
        graph.addEdge("1011", "1003");
        graph.addEdge("1012", "1004");

        // 库前转运区
        graph.addEdge("1009", "R1");
        graph.addEdge("1010", "R2");
        graph.addEdge("1011", "R3");
        graph.addEdge("1012", "R4");
//
        graph.addEdge("R1", "1009");
        graph.addEdge("R1", "R2");

        graph.addEdge("R2", "1010");
        graph.addEdge("R2", "R1");
        graph.addEdge("R2", "1018");
        graph.addEdge("R2", "R3");

        graph.addEdge("R3", "1011");
        graph.addEdge("R3", "R2");
        graph.addEdge("R3", "1019");
        graph.addEdge("R3", "R4");

        graph.addEdge("R4", "1012");
        graph.addEdge("R4", "R3");

        graph.addEdge("1017", "R1");
        graph.addEdge("1020", "R4");

        //立库接驳区
        graph.addEdge("1018", "1026");
        graph.addEdge("1019", "1027");

        graph.addEdge("1025", "1017");
        graph.addEdge("1028", "1020");

        //立库搬运
        graph.addEdge("S1", "1025");
        graph.addEdge("1026", "S1");
        graph.addEdge("1027", "S2");
        graph.addEdge("S2", "1028");

        // 设定全量端点
        graph.routePlanning(Lists.newArrayList("1001", "1009"));

        List<List<String>> lists = graph.routePlanning(Lists.newArrayList("1001", "S2"));

//        List<String> lists = graph.shortestRoute("1003", "1002");
        System.out.printf(JSON.toJSONString(lists));
    }


    // [
    //  ["1001","1009","R1","R2","1010","1002"],
    //  ["1001","1009","R1","R2","1018","1026","S1"],
    //  ["1001","1009","R1","R2","R3","1011","1003"],
    //  ["1001","1009","R1","R2","R3","1019","1027","S2"],
    //  ["1001","1009","R1","R2","R3","R4","1012","1004"],
    //  ["1002","1010","R2","R1","1009","1001"],
    //  ["1002","1010","R2","1018","1026","S1"],
    //  ["1002","1010","R2","R3","1011","1003"],
    //  ["1002","1010","R2","R3","1019","1027","S2"],
    //  ["1002","1010","R2","R3","R4","1012","1004"],
    //  ["1003","1011","R3","R2","1010","1002"],
    //  ["1003","1011","R3","R2","R1","1009","1001"],
    //  ["1003","1011","R3","R2","1018","1026","S1"],
    //  ["1003","1011","R3","1019","1027","S2"],
    //  ["1003","1011","R3","R4","1012","1004"],
    //  ["1004","1012","R4","R3","1011","1003"],
    //  ["1004","1012","R4","R3","R2","1010","1002"],
    //  ["1004","1012","R4","R3","R2","R1","1009","1001"],
    //  ["1004","1012","R4","R3","R2","1018","1026","S1"],
    //  ["1004","1012","R4","R3","1019","1027","S2"],
    //  ["S1","1025","1017","R1","1009","1001"],
    //  ["S1","1025","1017","R1","R2","1010","1002"],
    //  ["S1","1025","1017","R1","R2","R3","1011","1003"],
    //  ["S1","1025","1017","R1","R2","R3","1019","1027","S2"],
    //  ["S1","1025","1017","R1","R2","R3","R4","1012","1004"],
    //  ["S2","1028","1020","R4","1012","1004"],
    //  ["S2","1028","1020","R4","R3","1011","1003"],
    //  ["S2","1028","1020","R4","R3","R2","1010","1002"],
    //  ["S2","1028","1020","R4","R3","R2","R1","1009","1001"],
    //  ["S2","1028","1020","R4","R3","R2","1018","1026","S1"]
    // ]


}
