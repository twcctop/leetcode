package leetcode_每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;
import util.ArrayUtil;

public class _0126_2013 {

  //监测正方形
  class DetectSquares {

    Map<Integer, Set<Integer>> map;

    public DetectSquares() {
      map = new HashMap<>();
    }

    public void add(int[] point) {
      Set<Integer> set = map.getOrDefault(point[0], new HashSet<>());
      set.add(point[1]);
      map.putIfAbsent(point[0], set);
    }

    public int count(int[] point) {
      int cout = 0;
      Set<Integer> points = map.get(point[0]);
      List<Integer> list = new ArrayList<>(points);
      List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());

      var offset = point[1];
      for (int i = 0; i < offset; i++) {
        for (int j = sortedList.size() - 1; j >= 0; j--) {
          if (i == point[1] || j == point[1]) {
            continue;
          }

          if (offset - i == j - offset) {
            if (point[0] - offset < 0) {
              continue;
            }
            Set<Integer> integers = map.get(point[0] - offset);
            if (integers.contains(i) && integers.contains(j)) {
              cout++;
            }

          }
        }

      }
      return cout;
    }


  }

  /**
   * @Description
   * @Date 2022/1/26  9:45
   **/
  @Test
  public void test() {
    DetectSquares detectSquares = new DetectSquares();
    detectSquares.add(ArrayUtil.convertStringIntToArray("[3, 10]"));
    detectSquares.add(ArrayUtil.convertStringIntToArray("[11, 2]"));
    detectSquares.add(ArrayUtil.convertStringIntToArray("[3, 2]"));
    detectSquares.count(ArrayUtil.convertStringIntToArray("[11, 10]"));

  }
}
