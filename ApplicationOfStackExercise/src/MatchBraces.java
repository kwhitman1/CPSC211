import java.util.Scanner;
import java.util.Stack;

public class MatchBraces {
	
	public void check(Scanner scanner) {
        Stack<BraceDetails> stack = new Stack<>();
        int lineNum = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineNum++;

            for (int i = 0; i < line.length(); i++) {
                char character = line.charAt(i);

                if (character == '(' || character == '[' || character == '{') {
                    stack.push(new BraceDetails(character, lineNum, i + 1));
                }

                else if (character == ')' || character == ']' || character == '}') {
                    if (stack.isEmpty()) {
                        System.out.println("Unmatched closing brace '" + character + "' at line " + lineNum + ", position " + (i + 1));
                        return;
                    }

                    char endBrace = stack.pop().b;

                    if (!isGoodPair(endBrace, character)) {
                        System.out.println("Mismatched brace '" + character + "' at line " + lineNum + ", position " + (i + 1));
                        return;
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            BraceDetails unmatchedBrace = stack.pop();
            System.out.println("Unmatched opening brace '" + unmatchedBrace.b + "' at line " + unmatchedBrace.l + ", position " + unmatchedBrace.p);
        } else {
            System.out.println("All braces match.");
        }
    }

    public boolean isGoodPair(char openBrace, char closeBrace) {
        return (openBrace == '(' && closeBrace == ')') ||
               (openBrace == '[' && closeBrace == ']') ||
               (openBrace == '{' && closeBrace == '}');
    }

}
