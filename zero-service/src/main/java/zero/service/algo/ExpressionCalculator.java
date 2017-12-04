package zero.service.algo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionCalculator {

    public static String eval(String exp) throws Exception {
        try {
            List<String> postfixExp = genPostfixExp("(" + exp + ")");
            return doEval(postfixExp);
        } catch (Exception e) {
            throw new Exception("表达式不合法");
        }
    }

    private static String doEval(List<String> list) throws Exception {
        try {
            Stack<String> numStack = new Stack<>();
            double n1, n2, result;
            for (String element : list) {
                if (isOperator(element)) {
                    n1 = Double.parseDouble(numStack.pop() + "");
                    n2 = Double.parseDouble(numStack.pop() + "");
                    result = doOperate(n2, n1, element);
                    numStack.push(String.valueOf(result));
                } else {
                    numStack.push(String.valueOf(element));
                }
            }
            String value = numStack.pop();
            if (!numStack.isEmpty()) {
                throw new Exception("表达式不合法");
            }
            return value;
        } catch (Exception e) {
            throw new Exception("表达式不合法");
        }
    }

    private static List<String> genPostfixExp(String exp) throws Exception {
        exp = exp + "#";
        List<String> postfixList = new ArrayList<>();
        Stack<String> opStack = new Stack<>();
        StringBuffer numberBuffer = new StringBuffer();

        Stack<Boolean> signStack = new Stack<>();
        boolean sign = false;
        boolean changeSign = false;

        opStack.push("#");
        for (int i = 0; i < exp.length(); ) {
            char c = exp.charAt(i);
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (priority(opStack.peek().charAt(0)) >= priority(c)) {
                        postfixList.add(opStack.pop());
                    }
                    opStack.push(String.valueOf(c));
                    i++;
                    break;
                case '(':
                    if (changeSign) {
                        sign = !sign;
                        changeSign = false;
                    }
                    signStack.push(sign);
                    opStack.push(String.valueOf(c));
                    i++;
                    if (exp.charAt(i) == '-') {
                        changeSign = true;
                        i++;
                    } else if (exp.charAt(i) == '+') {
                        i++;
                    }
                    break;
                case ')':
                    signStack.pop();
                    if (!signStack.isEmpty()) {
                        sign = signStack.peek();
                    }
                    String peek = opStack.pop();
                    while (peek.charAt(0) != '(') {
                        postfixList.add(String.valueOf(peek));
                        peek = opStack.pop();
                    }
                    i++;
                    break;
                case '#':
                    String peek1;
                    while (!opStack.isEmpty()) {
                        peek1 = opStack.pop();
                        if (peek1.charAt(0) != '#') {
                            postfixList.add(String.valueOf(peek1));
                        }
                    }
                    i++;
                    break;
                case ' ':
                case '\t':
                    i++;
                    break;
                default:
                    if (Character.isDigit(c) || c == '.') {
                        if (changeSign) {
                            changeSign = false;
                            if (!sign) {
                                numberBuffer.append("-");
                            }
                        } else if (sign) {
                            numberBuffer.append("-");
                        }
                        while (Character.isDigit(c) || c == '.') {
                            numberBuffer.append(c);
                            c = exp.charAt(++i);
                        }
                        postfixList.add(numberBuffer.toString());
                        numberBuffer = new StringBuffer();
                    } else {
                        throw new Exception(MessageFormat.format("不合法的输入符{0}", c));
                    }
            }
        }
        return postfixList;
    }

    private static int priority(char op) throws Exception {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
            case '#':
                return 0;
        }
        throw new Exception(MessageFormat.format("不合法的操作符{0}", op));
    }

    private static double doOperate(double n1, double n2, String op) {
        double result;
        switch (op.charAt(0)) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            default:
                result = n1 / n2;
                break;
        }
        return result;
    }

    private static boolean isOperator(String str) {
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }

}