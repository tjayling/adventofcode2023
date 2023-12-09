package code.day8;

import code.utils.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part1 {
  private static final FileReader fileReader = new FileReader();
  private static final List<String> inputs = fileReader.readFile("/Users/aylint1/IdeaProjects/me/advent of code 23/src/resources/day3/input.txt");

  public static void run() {

    String instructionSet = inputs.get(0);

    inputs.removeFirst();
    inputs.removeFirst();

    Map<String, Instruction> instructionMap = getInstructions();

    Instruction currentInstruction = instructionMap.get("AAA");
    int count = 0;

    while (true) {
      for (Character c : instructionSet.toCharArray()) {
        count++;
        String nextInstructionKey = currentInstruction.getNext(c);
        System.out.println("Next instruction key: " + nextInstructionKey);
        if (nextInstructionKey.equals("ZZZ")) {
          System.out.println("Result: " + count);
          return;
        }
        currentInstruction = instructionMap.get(nextInstructionKey);
      }
    }
  }

  private static Map<String, Instruction> getInstructions() {
    Map<String, Instruction> result = new HashMap<>();

    for (String input : inputs) {
      String[] split = input.split(" = ");
      String key = split[0];
      String inBrackets = split[1].substring(split[1].indexOf("(") + 1);
      inBrackets = inBrackets.substring(0, inBrackets.indexOf(")"));
      String left = inBrackets.split(", ")[0];
      String right = inBrackets.split(", ")[1];
      result.put(key, new Instruction(left, right));
    }
    return result;
  }

  private static class Instruction {
    private final String left;
    private final String right;

    public Instruction(String left, String right) {
      this.left = left;
      this.right = right;
    }

    public String getNext(char next) {
      return switch (next) {
        case 'L' -> this.left;
        case 'R' -> this.right;
        default -> throw new RuntimeException("Invalid input: " + next);
      };
    }
  }
}
