package edu.illinois.cs.cs125.mp_7;
/** Makes calculations inputted by the calculator. */
public class Calculate {
    private String input = "";

    public void clear() {
        input = "";
    }

    public void addNumberToString(final String number) {
        input += number;
    }

    public void addOperationToString(final String operation) {
        input += " " + operation + " ";
    }

    private boolean hasSymbol(final String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals("+") || calculation.substring(i, i + 1).equals("-")) {
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

    private boolean hasPower(final String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals("^")) {
                return true;
            }
        }
        return false;
    }

    private boolean hasParentheses(final String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals("(")) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDivision(final String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals("/")) {
                return true;
            }
        }
        return false;
    }

    private boolean hasMultiply(final String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals("*")) {
                return true;
            }
        }
        return false;
    }

    private boolean hasAdd(final String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals("+")) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSubtract(final String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals("-")) {
                return true;
            }
        }
        return false;
    }

    private int findSymbol(final String calculation, final String operation) {
        for (int i = 0; i < calculation.length(); i++) {
            if (calculation.substring(i, i + 1).equals(operation)) {
                return i;
            }
        }
        return 0;
    }

    private double leftNumber(final String calculation, final int index) {
        for (int i = index - 2; i >= 0; i--) {
            if (calculation.startsWith(" ", i)) {
                return Double.parseDouble(calculation.substring(i, index));
            }
        }
        return Double.parseDouble(calculation.substring(0, index - 1));
    }

    private double rightNumber(final String calculation, final int index) {
        for (int i = index + 2; i < calculation.length(); i++) {
            if (calculation.substring(index, i + 1).endsWith(" ")) {
                return Double.parseDouble(calculation.substring(index + 2, i));
            }
        }
        return Double.parseDouble(calculation.substring(index + 2, calculation.length()));
    }

    /* LeftString and rightString do not leave spaces. */
    private String leftString(final String calculation, final int index) {
        for (int i = index - 2; i >= 0; i--) {
            if (calculation.startsWith(" ", i)) {
                return calculation.substring(0, i);
            }
        }
        return null;
    }

    private String rightString(final String calculation, final int index) {
        for (int i = index + 2; i < calculation.length(); i++) {
            if (calculation.substring(index, i + 1).endsWith(" ")) {
                return calculation.substring(i + 1, calculation.length());
            }
        }
        return null;
    }

    private String calculateParentheses(final String parentheses) {
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
                if (findSymbol(parentheses, "+") < findSymbol(parentheses, "-")) {
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
                    int index = findSymbol(parentheses, "-");
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
                int index = findSymbol(parentheses, "-");
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

    public String calculate() {
        if (hasSymbol(input) == false) {
            return input;
        } else {
            if (hasParentheses(input) == true) {
                int leftIndex = findSymbol(input, "(");
                int rightIndex = findSymbol(input, ")");
                String parentheses = calculateParentheses(input.substring(leftIndex + 2, rightIndex - 2));
                if (leftString(input, leftIndex) != null && rightString(input, rightIndex) != null) {
                    input = leftString(input, leftIndex) + " " + parentheses + " " + rightString(input, rightIndex);
                    return calculate();
                } else if (leftString(input, leftIndex) != null) {
                    input = leftString(input, leftIndex) + " " + parentheses;
                    return calculate();
                } else if (rightString(input, rightIndex) != null) {
                    input = parentheses + " " + rightString(input, rightIndex);
                    return calculate();
                } else {
                    input = parentheses;
                    return calculate();
                }
            }
            if (hasPower(input) == true) {
                int index = findSymbol(input, "^");
                double left = leftNumber(input, index);
                double right = rightNumber(input, index);
                double answer = Math.pow(left, right);
                if (leftString(input, index) != null && rightString(input, index) != null) {
                    input = leftString(input, index) + " " + Double.toString(answer) + " " + rightString(input, index);
                    return calculate();
                } else if (leftString(input, index) != null) {
                    input = leftString(input, index) + " " + Double.toString(answer);
                    return calculate();
                } else if (rightString(input, index) != null) {
                    input = Double.toString(answer) + " " + rightString(input, index);
                    return calculate();
                } else {
                    input = Double.toString(answer);
                    return calculate();
                }
            }
            if (hasMultiply(input) == true && hasDivision(input) == true) {
                if (findSymbol(input, "*") < findSymbol(input, "/")) {
                    int index = findSymbol(input, "*");
                    double left = leftNumber(input, index);
                    double right = rightNumber(input, index);
                    double answer = left*right;
                    if (leftString(input, index) != null && rightString(input, index) != null) {
                        input = leftString(input, index) + " " + Double.toString(answer) + " " + rightString(input, index);
                        return calculate();
                    } else if (leftString(input, index) != null) {
                        input = leftString(input, index) + " " + Double.toString(answer);
                        return calculate();
                    } else if (rightString(input, index) != null) {
                        input = Double.toString(answer) + " " + rightString(input, index);
                        return calculate();
                    } else {
                        input = Double.toString(answer);
                        return calculate();
                    }
                } else {
                    int index = findSymbol(input, "/");
                    double left = leftNumber(input, index);
                    double right = rightNumber(input, index);
                    double answer = left/right;
                    if (leftString(input, index) != null && rightString(input, index) != null) {
                        input = leftString(input, index) + " " + Double.toString(answer) + " " + rightString(input, index);
                        return calculate();
                    } else if (leftString(input, index) != null) {
                        input = leftString(input, index) + " " + Double.toString(answer);
                        return calculate();
                    } else if (rightString(input, index) != null) {
                        input = Double.toString(answer) + " " + rightString(input, index);
                        return calculate();
                    } else {
                        input = Double.toString(answer);
                        return calculate();
                    }
                }

            } else if (hasMultiply(input) == true) {
                int index = findSymbol(input, "*");
                double left = leftNumber(input, index);
                double right = rightNumber(input, index);
                double answer = left*right;
                if (leftString(input, index) != null && rightString(input, index) != null) {
                    input = leftString(input, index) + " " + Double.toString(answer) + " " + rightString(input, index);
                    return calculate();
                } else if (leftString(input, index) != null) {
                    input = leftString(input, index) + " " + Double.toString(answer);
                    return calculate();
                } else if (rightString(input, index) != null) {
                    input = Double.toString(answer) + " " + rightString(input, index);
                    return calculate();
                } else {
                    input = Double.toString(answer);
                    return calculate();
                }
            } else if (hasDivision(input) == true) {
                int index = findSymbol(input, "/");
                double left = leftNumber(input, index);
                double right = rightNumber(input, index);
                double answer = left/right;
                if (leftString(input, index) != null && rightString(input, index) != null) {
                    input = leftString(input, index) + " " + Double.toString(answer) + " " + rightString(input, index);
                    return calculate();
                } else if (leftString(input, index) != null) {
                    input = leftString(input, index) + " " + Double.toString(answer);
                    return calculate();
                } else if (rightString(input, index) != null) {
                    input = Double.toString(answer) + " " + rightString(input, index);
                    return calculate();
                } else {
                    input = Double.toString(answer);
                    return calculate();
                }
            }
            if (hasAdd(input) == true && hasSubtract(input) == true) {
                if (findSymbol(input, "+") < findSymbol(input, "-")) {
                    int index = findSymbol(input, "+");
                    double left = leftNumber(input, index);
                    double right = rightNumber(input, index);
                    double answer = left + right;
                    if (leftString(input, index) != null && rightString(input, index) != null) {
                        input = leftString(input, index) + " " + Double.toString(answer) + " " + rightString(input, index);
                        return calculate();
                    } else if (leftString(input, index) != null) {
                        input = leftString(input, index) + " " + Double.toString(answer);
                        return calculate();
                    } else if (rightString(input, index) != null) {
                        input = Double.toString(answer) + " " + rightString(input, index);
                        return calculate();
                    } else {
                        input = Double.toString(answer);
                        return calculate();
                    }
                } else {
                    int index = findSymbol(input, "-");
                    double left = leftNumber(input, index);
                    double right = rightNumber(input, index);
                    double answer = left - right;
                    if (leftString(input, index) != null && rightString(input, index) != null) {
                        input = leftString(input, index) + " " + Double.toString(answer) + " " + rightString(input, index);
                        return calculate();
                    } else if (leftString(input, index) != null) {
                        input = leftString(input, index) + " " + Double.toString(answer);
                        return calculate();
                    } else if (rightString(input, index) != null) {
                        input = Double.toString(answer) + " " + rightString(input, index);
                        return calculate();
                    } else {
                        input = Double.toString(answer);
                        return calculate();
                    }
                }
            } else if (hasAdd(input) == true) {
                int index = findSymbol(input, "+");
                double left = leftNumber(input, index);
                double right = rightNumber(input, index);
                double answer = left + right;
                if (leftString(input, index) != null && rightString(input, index) != null) {
                    input = leftString(input, index) + " " + Double.toString(answer) + " " + rightString(input, index);
                    return calculate();
                } else if (leftString(input, index) != null) {
                    input = leftString(input, index) + " " + Double.toString(answer);
                    return calculate();
                } else if (rightString(input, index) != null) {
                    input = Double.toString(answer) + " " + rightString(input, index);
                    return calculate();
                } else {
                    input = Double.toString(answer);
                    return calculate();
                }
            } else if (hasSubtract(input) == true) {
                int index = findSymbol(input, "-");
                double left = leftNumber(input, index);
                double right = rightNumber(input, index);
                double answer = left - right;
                if (leftString(input, index) != null && rightString(input, index) != null) {
                    input = leftString(input, index) + " " + Double.toString(answer) + " " + rightString(input, index);
                    return calculate();
                } else if (leftString(input, index) != null) {
                    input = leftString(input, index) + " " + Double.toString(answer);
                    return calculate();
                } else if (rightString(input, index) != null) {
                    input = Double.toString(answer) + " " + rightString(input, index);
                    return calculate();
                } else {
                    input = Double.toString(answer);
                    return calculate();
                }
            }
        }
        return calculate();
    }
}
