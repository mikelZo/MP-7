package edu.illinois.cs.cs125.mp_7;
/** Makes calculations inputted by the calculator. */
public class Calculate {
    private static String input = "";
    private static String output = "";

    public static void clear() {
        input = "";
        output = "";
    }

    public static void addNumberToString(final String number) {
        input += number;
        output += number;
    }

    public static void addOperationToInput(final String operation) {
        input += " " + operation + " ";
    }

    public static void addOperationToOutput(final String operation) {
        output += " " + operation + " ";
    }

    public static void delete() {
        if (input.length() > 1) {
            input = input.substring(0, input.length() - 1);
            output = output.substring(0, output.length() - 1);
        } else {
            input = "";
            output = "";
        }
    }

    public static String getString() {
        return input;
    }

    public static String getAnswer() {
        return output;
    }

    private static boolean hasSymbol(final String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals("+") || calculation.substring(i, i + 1).equals("@")) {
                return true;
            }
            if (calculation.substring(i, i + 1).equals("*") || calculation.substring(i, i + 1).equals("/")) {
                return true;
            }
            if (calculation.substring(i, i + 1).equals("(") || calculation.substring(i, i + 1).equals("^")) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasPower(final String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals("^")) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasParentheses(final String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals("(")) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDivision(final String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals("/")) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasMultiply(final String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals("*")) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasAdd(final String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals("+")) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSubtract(final String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals("@")) {
                return true;
            }
        }
        return false;
    }

    private static int findSymbol(final String calculation, final String operation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals(operation)) {
                return i;
            }
        }
        return 0;
    }

    private static double leftNumber(final String calculation, final int index) {
        for (int i = index - 2; i >= 0; i--) {
            if (calculation.startsWith(" ", i)) {
                return Double.parseDouble(calculation.substring(i, index));
            }
        }
        return Double.parseDouble(calculation.substring(0, index - 1));
    }

    private static double rightNumber(final String calculation, final int index) {
        for (int i = index + 2; i < calculation.length(); i++) {
            if (calculation.substring(index, i + 1).endsWith(" ")) {
                return Double.parseDouble(calculation.substring(index + 2, i));
            }
        }
        return Double.parseDouble(calculation.substring(index + 2, calculation.length()));
    }

    /* LeftString and rightString do not leave spaces. */
    private static String leftString(final String calculation, final int index) {
        for (int i = index - 2; i >= 0; i--) {
            if (calculation.startsWith(" ", i)) {
                return calculation.substring(0, i);
            }
        }
        return null;
    }

    private static String rightString(final String calculation, final int index) {
        for (int i = index + 2; i < calculation.length(); i++) {
            if (calculation.substring(index, i + 1).endsWith(" ")) {
                return calculation.substring(i + 1, calculation.length());
            }
        }
        return null;
    }

    private static String calculateParentheses(final String parentheses) {
        if (hasSymbol(parentheses) == false) {
            return parentheses;
        } else {
            if (hasParentheses(parentheses) == true) {
                int leftIndex = findSymbol(parentheses, "(");
                int rightIndex = findSymbol(parentheses, ")");
                String calculate = calculateParentheses(parentheses.substring(leftIndex + 2, rightIndex - 2));
                if (leftString(parentheses, leftIndex) != null && rightString(parentheses, rightIndex) != null) {
                    String reduced = leftString(parentheses, leftIndex) + " " + calculate + " " + rightString(parentheses, rightIndex);
                    return calculateParentheses(reduced);
                } else if (leftString(parentheses, leftIndex) != null) {
                    String reduced = leftString(parentheses, leftIndex) + " " + calculate;
                    return calculateParentheses(reduced);
                } else if (rightString(parentheses, rightIndex) != null) {
                    String reduced = calculate + " " + rightString(parentheses, rightIndex);
                    return calculateParentheses(reduced);
                } else {
                    String reduced = parentheses;
                    return calculateParentheses(reduced);
                }
            }
            if (hasPower(parentheses) == true) {
                int index = findSymbol(parentheses, "^");
                double left = leftNumber(parentheses, index);
                double right = rightNumber(parentheses, index);
                double answer = Math.pow(left, right);
                if (leftString(parentheses, index) != null && rightString(parentheses, index) != null) {
                    String reduced = leftString(parentheses, index) + " " + Double.toString(answer) + " " + rightString(parentheses, index);
                    return calculateParentheses(reduced);
                } else if (leftString(parentheses, index) != null) {
                    String reduced = leftString(parentheses, index) + " " + Double.toString(answer);
                    return calculateParentheses(reduced);
                } else if (rightString(parentheses, index) != null) {
                    String reduced = Double.toString(answer) + " " + rightString(parentheses, index);
                    return calculateParentheses(reduced);
                } else {
                    String reduced = Double.toString(answer);
                    return calculateParentheses(reduced);
                }
            }
            if (hasMultiply(parentheses) == true && hasDivision(parentheses) == true) {
                if (findSymbol(parentheses, "*") < findSymbol(parentheses, "/")) {
                    int index = findSymbol(parentheses, "*");
                    double left = leftNumber(parentheses, index);
                    double right = rightNumber(parentheses, index);
                    double answer = left*right;
                    if (leftString(parentheses, index) != null && rightString(parentheses, index) != null) {
                        String reduced = leftString(parentheses, index) + " " + Double.toString(answer) + " " + rightString(parentheses, index);
                        return calculateParentheses(reduced);
                    } else if (leftString(parentheses, index) != null) {
                        String reduced = leftString(parentheses, index) + " " + Double.toString(answer);
                        return calculateParentheses(reduced);
                    } else if (rightString(parentheses, index) != null) {
                        String reduced = Double.toString(answer) + " " + rightString(parentheses, index);
                        return calculateParentheses(reduced);
                    } else {
                        String reduced = Double.toString(answer);
                        return calculateParentheses(reduced);
                    }
                } else {
                    int index = findSymbol(parentheses, "/");
                    double left = leftNumber(parentheses, index);
                    double right = rightNumber(parentheses, index);
                    double answer = left/right;
                    if (leftString(parentheses, index) != null && rightString(parentheses, index) != null) {
                        String reduced = leftString(parentheses, index) + " " + Double.toString(answer) + " " + rightString(parentheses, index);
                        return calculateParentheses(reduced);
                    } else if (leftString(parentheses, index) != null) {
                        String reduced = leftString(parentheses, index) + " " + Double.toString(answer);
                        return calculateParentheses(reduced);
                    } else if (rightString(parentheses, index) != null) {
                        String reduced = Double.toString(answer) + " " + rightString(parentheses, index);
                        return calculateParentheses(reduced);
                    } else {
                        String reduced = Double.toString(answer);
                        return calculateParentheses(reduced);
                    }
                }

            } else if (hasMultiply(parentheses) == true) {
                int index = findSymbol(parentheses, "*");
                double left = leftNumber(parentheses, index);
                double right = rightNumber(parentheses, index);
                double answer = left*right;
                if (leftString(parentheses, index) != null && rightString(parentheses, index) != null) {
                    String reduced = leftString(parentheses, index) + " " + Double.toString(answer) + " " + rightString(parentheses, index);
                    return calculateParentheses(reduced);
                } else if (leftString(parentheses, index) != null) {
                    String reduced = leftString(parentheses, index) + " " + Double.toString(answer);
                    return calculateParentheses(reduced);
                } else if (rightString(parentheses, index) != null) {
                    String reduced = Double.toString(answer) + " " + rightString(parentheses, index);
                    return calculateParentheses(reduced);
                } else {
                    String reduced = Double.toString(answer);
                    return calculateParentheses(reduced);
                }
            } else if (hasDivision(parentheses) == true) {
                int index = findSymbol(parentheses, "/");
                double left = leftNumber(parentheses, index);
                double right = rightNumber(parentheses, index);
                double answer = left/right;
                if (leftString(parentheses, index) != null && rightString(parentheses, index) != null) {
                    String reduced = leftString(parentheses, index) + " " + Double.toString(answer) + " " + rightString(parentheses, index);
                    return calculateParentheses(reduced);
                } else if (leftString(parentheses, index) != null) {
                    String reduced = leftString(parentheses, index) + " " + Double.toString(answer);
                    return calculateParentheses(reduced);
                } else if (rightString(parentheses, index) != null) {
                    String reduced = Double.toString(answer) + " " + rightString(parentheses, index);
                    return calculateParentheses(reduced);
                } else {
                    String reduced = Double.toString(answer);
                    return calculateParentheses(reduced);
                }
            }
            if (hasAdd(parentheses) == true && hasSubtract(parentheses) == true) {
                if (findSymbol(parentheses, "+") < findSymbol(parentheses, "@")) {
                    int index = findSymbol(parentheses, "+");
                    double left = leftNumber(parentheses, index);
                    double right = rightNumber(parentheses, index);
                    double answer = left + right;
                    if (leftString(parentheses, index) != null && rightString(parentheses, index) != null) {
                        String reduced = leftString(parentheses, index) + " " + Double.toString(answer) + " " + rightString(parentheses, index);
                        return calculateParentheses(reduced);
                    } else if (leftString(parentheses, index) != null) {
                        String reduced = leftString(parentheses, index) + " " + Double.toString(answer);
                        return calculateParentheses(reduced);
                    } else if (rightString(parentheses, index) != null) {
                        String reduced = Double.toString(answer) + " " + rightString(parentheses, index);
                        return calculateParentheses(reduced);
                    } else {
                        String reduced = Double.toString(answer);
                        return calculateParentheses(reduced);
                    }
                } else {
                    int index = findSymbol(parentheses, "@");
                    double left = leftNumber(parentheses, index);
                    double right = rightNumber(parentheses, index);
                    double answer = left - right;
                    if (leftString(parentheses, index) != null && rightString(parentheses, index) != null) {
                        String reduced = leftString(parentheses, index) + " " + Double.toString(answer) + " " + rightString(parentheses, index);
                        return calculateParentheses(reduced);
                    } else if (leftString(parentheses, index) != null) {
                        String reduced = leftString(parentheses, index) + " " + Double.toString(answer);
                        return calculateParentheses(reduced);
                    } else if (rightString(parentheses, index) != null) {
                        String reduced = Double.toString(answer) + " " + rightString(parentheses, index);
                        return calculateParentheses(reduced);
                    } else {
                        String reduced = Double.toString(answer);
                        return calculateParentheses(reduced);
                    }
                }
            } else if (hasAdd(parentheses) == true) {
                int index = findSymbol(parentheses, "+");
                double left = leftNumber(parentheses, index);
                double right = rightNumber(parentheses, index);
                double answer = left + right;
                if (leftString(parentheses, index) != null && rightString(parentheses, index) != null) {
                    String reduced = leftString(parentheses, index) + " " + Double.toString(answer) + " " + rightString(parentheses, index);
                    return calculateParentheses(reduced);
                } else if (leftString(parentheses, index) != null) {
                    String reduced = leftString(parentheses, index) + " " + Double.toString(answer);
                    return calculateParentheses(reduced);
                } else if (rightString(parentheses, index) != null) {
                    String reduced = Double.toString(answer) + " " + rightString(parentheses, index);
                    return calculateParentheses(reduced);
                } else {
                    String reduced = Double.toString(answer);
                    return calculateParentheses(reduced);
                }
            } else if (hasSubtract(parentheses) == true) {
                int index = findSymbol(parentheses, "@");
                double left = leftNumber(parentheses, index);
                double right = rightNumber(parentheses, index);
                double answer = left - right;
                if (leftString(parentheses, index) != null && rightString(parentheses, index) != null) {
                    String reduced = leftString(parentheses, index) + " " + Double.toString(answer) + " " + rightString(parentheses, index);
                    return calculateParentheses(reduced);
                } else if (leftString(parentheses, index) != null) {
                    String reduced = leftString(parentheses, index) + " " + Double.toString(answer);
                    return calculateParentheses(reduced);
                } else if (rightString(parentheses, index) != null) {
                    String reduced = Double.toString(answer) + " " + rightString(parentheses, index);
                    return calculateParentheses(reduced);
                } else {
                    String reduced = Double.toString(answer);
                    return calculateParentheses(reduced);
                }
            }
        }
        return calculateParentheses(parentheses);
    }

    public static String calculate() {
        if (hasSymbol(output) == false) {
            return output;
        } else {
            if (hasParentheses(output) == true) {
                int leftIndex = findSymbol(output, "(");
                int rightIndex = findSymbol(output, ")");
                String parentheses = calculateParentheses(output.substring(leftIndex + 2, rightIndex - 1));
                if (leftString(output, leftIndex) != null && rightString(output, rightIndex) != null) {
                    output = leftString(output, leftIndex) + " " + parentheses + " " + rightString(output, rightIndex);
                    return calculate();
                } else if (leftString(output, leftIndex) != null) {
                    output = leftString(output, leftIndex) + " " + parentheses;
                    return calculate();
                } else if (rightString(output, rightIndex) != null) {
                    output = parentheses + " " + rightString(output, rightIndex);
                    return calculate();
                } else {
                    output = parentheses;
                    return calculate();
                }
            }
            if (hasPower(output) == true) {
                int index = findSymbol(output, "^");
                double left = leftNumber(output, index);
                double right = rightNumber(output, index);
                double answer = Math.pow(left, right);
                if (leftString(output, index) != null && rightString(output, index) != null) {
                    output = leftString(output, index) + " " + Double.toString(answer) + " " + rightString(output, index);
                    return calculate();
                } else if (leftString(output, index) != null) {
                    output = leftString(output, index) + " " + Double.toString(answer);
                    return calculate();
                } else if (rightString(output, index) != null) {
                    output = Double.toString(answer) + " " + rightString(output, index);
                    return calculate();
                } else {
                    output = Double.toString(answer);
                    return calculate();
                }
            }
            if (hasMultiply(output) == true && hasDivision(output) == true) {
                if (findSymbol(output, "*") < findSymbol(output, "/")) {
                    int index = findSymbol(output, "*");
                    double left = leftNumber(output, index);
                    double right = rightNumber(output, index);
                    double answer = left*right;
                    if (leftString(output, index) != null && rightString(output, index) != null) {
                        output = leftString(output, index) + " " + Double.toString(answer) + " " + rightString(output, index);
                        return calculate();
                    } else if (leftString(output, index) != null) {
                        output = leftString(output, index) + " " + Double.toString(answer);
                        return calculate();
                    } else if (rightString(output, index) != null) {
                        output = Double.toString(answer) + " " + rightString(output, index);
                        return calculate();
                    } else {
                        output = Double.toString(answer);
                        return calculate();
                    }
                } else {
                    int index = findSymbol(output, "/");
                    double left = leftNumber(output, index);
                    double right = rightNumber(output, index);
                    double answer = left/right;
                    if (leftString(output, index) != null && rightString(output, index) != null) {
                        output = leftString(output, index) + " " + Double.toString(answer) + " " + rightString(output, index);
                        return calculate();
                    } else if (leftString(output, index) != null) {
                        output = leftString(output, index) + " " + Double.toString(answer);
                        return calculate();
                    } else if (rightString(output, index) != null) {
                        output = Double.toString(answer) + " " + rightString(output, index);
                        return calculate();
                    } else {
                        output = Double.toString(answer);
                        return calculate();
                    }
                }

            } else if (hasMultiply(output) == true) {
                int index = findSymbol(output, "*");
                double left = leftNumber(output, index);
                double right = rightNumber(output, index);
                double answer = left*right;
                if (leftString(output, index) != null && rightString(output, index) != null) {
                    output = leftString(output, index) + " " + Double.toString(answer) + " " + rightString(output, index);
                    return calculate();
                } else if (leftString(output, index) != null) {
                    output = leftString(output, index) + " " + Double.toString(answer);
                    return calculate();
                } else if (rightString(output, index) != null) {
                    output = Double.toString(answer) + " " + rightString(output, index);
                    return calculate();
                } else {
                    output = Double.toString(answer);
                    return calculate();
                }
            } else if (hasDivision(output) == true) {
                int index = findSymbol(output, "/");
                double left = leftNumber(output, index);
                double right = rightNumber(output, index);
                double answer = left/right;
                if (leftString(output, index) != null && rightString(output, index) != null) {
                    output = leftString(output, index) + " " + Double.toString(answer) + " " + rightString(output, index);
                    return calculate();
                } else if (leftString(output, index) != null) {
                    output = leftString(output, index) + " " + Double.toString(answer);
                    return calculate();
                } else if (rightString(output, index) != null) {
                    output = Double.toString(answer) + " " + rightString(output, index);
                    return calculate();
                } else {
                    output = Double.toString(answer);
                    return calculate();
                }
            }
            if (hasAdd(output) == true && hasSubtract(output) == true) {
                if (findSymbol(output, "+") < findSymbol(output, "@")) {
                    int index = findSymbol(output, "+");
                    double left = leftNumber(output, index);
                    double right = rightNumber(output, index);
                    double answer = left + right;
                    if (leftString(output, index) != null && rightString(output, index) != null) {
                        output = leftString(output, index) + " " + Double.toString(answer) + " " + rightString(output, index);
                        return calculate();
                    } else if (leftString(output, index) != null) {
                        output = leftString(output, index) + " " + Double.toString(answer);
                        return calculate();
                    } else if (rightString(output, index) != null) {
                        output = Double.toString(answer) + " " + rightString(output, index);
                        return calculate();
                    } else {
                        output = Double.toString(answer);
                        return calculate();
                    }
                } else {
                    int index = findSymbol(output, "@");
                    double left = leftNumber(output, index);
                    double right = rightNumber(output, index);
                    double answer = left - right;
                    if (leftString(output, index) != null && rightString(output, index) != null) {
                        output = leftString(output, index) + " " + Double.toString(answer) + " " + rightString(output, index);
                        return calculate();
                    } else if (leftString(output, index) != null) {
                        output = leftString(output, index) + " " + Double.toString(answer);
                        return calculate();
                    } else if (rightString(output, index) != null) {
                        output = Double.toString(answer) + " " + rightString(output, index);
                        return calculate();
                    } else {
                        output = Double.toString(answer);
                        return calculate();
                    }
                }
            } else if (hasAdd(output) == true) {
                int index = findSymbol(output, "+");
                double left = leftNumber(output, index);
                double right = rightNumber(output, index);
                double answer = left + right;
                if (leftString(output, index) != null && rightString(output, index) != null) {
                    output = leftString(output, index) + " " + Double.toString(answer) + " " + rightString(output, index);
                    return calculate();
                } else if (leftString(output, index) != null) {
                    output = leftString(output, index) + " " + Double.toString(answer);
                    return calculate();
                } else if (rightString(output, index) != null) {
                    output = Double.toString(answer) + " " + rightString(output, index);
                    return calculate();
                } else {
                    output = Double.toString(answer);
                    return calculate();
                }
            } else if (hasSubtract(output) == true) {
                int index = findSymbol(output, "@");
                double left = leftNumber(output, index);
                double right = rightNumber(output, index);
                double answer = left - right;
                if (leftString(output, index) != null && rightString(output, index) != null) {
                    output = leftString(output, index) + " " + Double.toString(answer) + " " + rightString(output, index);
                    return calculate();
                } else if (leftString(output, index) != null) {
                    output = leftString(output, index) + " " + Double.toString(answer);
                    return calculate();
                } else if (rightString(output, index) != null) {
                    output = Double.toString(answer) + " " + rightString(output, index);
                    return calculate();
                } else {
                    output = Double.toString(answer);
                    return calculate();
                }
            }
        }
        return calculate();
    }
}
