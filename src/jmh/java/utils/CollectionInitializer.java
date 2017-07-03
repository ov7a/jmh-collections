package utils;

import java.util.List;

public class CollectionInitializer {
    public static void init(List<Integer> collection, int collectionSize) {
        for (int i = 0; i < collectionSize; i++) {
            collection.add(i);
        }
    }
}
