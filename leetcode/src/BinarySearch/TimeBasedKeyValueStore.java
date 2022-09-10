package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {


        class Node {
            String value;
            int timestamp;
            Node(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }

        Map<String, List<Node>> map;
        /** Initialize your data structure here. */
        public TimeBasedKeyValueStore() {
            map = new HashMap();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(new Node(value, timestamp));
        }

        public String get(String key, int timestamp) {
            List<Node> nodes = map.get(key);
            if (nodes == null) return "";

            int left = 0, right = nodes.size() - 1;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                Node node = nodes.get(mid);
                if (node.timestamp == timestamp) {
                    return node.value;
                } else if (node.timestamp < timestamp) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            if (nodes.get(right).timestamp <= timestamp) return nodes.get(right).value;
            else if (nodes.get(left).timestamp <= timestamp) return nodes.get(left).value;
            return "";
        }

}
