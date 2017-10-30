package eg.edu.alexu.csd.datastructure.stack.cs48;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

public class ExpressionEvaluator implements IExpressionEvaluator {

	public String infixToPostfix(String expression) {
		if (expression == "" || expression == null || expression == " ") {
			throw null;
		}
		Stack operators = new Stack();
		Character plus = new Character('+');
		Character minus = new Character('-');
		Character mult = new Character('*');
		Character div = new Character('/');

		String infix = expression;
		String postfix = "";
		expression = "";
		for (int i = 0; i < infix.length(); i++) {
			if (infix.charAt(i) != ' ') {
				expression = expression + infix.charAt(i);
			}
		}

		Character last = new Character(' ');

		for (int i = 0; i < expression.length(); i++) {
			Character tmp = new Character(expression.charAt(i));
			boolean bool1 = last.equals(plus) || last.equals(minus)
					|| last.equals(mult) || last.equals(div);
			boolean bool2 = tmp.equals(plus) || tmp.equals(minus)
					|| tmp.equals(mult) || tmp.equals(div);
			boolean bool_a = expression.charAt(i) == ')'
					|| expression.charAt(i) == '(';
			boolean bool_b = expression.charAt(i) >= 'a'
					&& expression.charAt(i) <= 'z';
			boolean bool_c = expression.charAt(i) >= 'A'
					&& expression.charAt(i) <= 'Z';
			boolean bool_d = expression.charAt(i) >= '0'
					&& expression.charAt(i) <= '9';

			if ((bool1 && bool2) || (expression.charAt(i) == ')' && bool1)) {
				throw null;
			}
			last = tmp;
			if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
				if (postfix == "" || i == expression.length() - 1) {
					throw null;
				}
				if (operators.size() == 0 || (operators.peek().equals(tmp))) {
					operators.push(tmp);
				} else {
					Character paren = new Character('(');
					while (operators.size() > 0
							&& (!operators.peek().equals(tmp))
							&& (!operators.peek().equals(paren))) {
						Character tmpo;
						tmpo = (Character) operators.pop();
						postfix = postfix + tmpo.charValue();
						postfix = postfix + " ";
					}
					operators.push(tmp);
				}
			} else if (expression.charAt(i) == '*'
					|| expression.charAt(i) == '/') {
				if (postfix == "" || i == expression.length() - 1) {
					throw null;
				}
				if (operators.size() == 0 || operators.peek().equals(tmp)) {
					operators.push(tmp);
				}

				else {
					Character paren = new Character('(');
					while (operators.size() > 0
							&& (operators.peek().equals(mult) || operators
									.peek().equals(div))
							&& (!operators.peek().equals(paren))) {
						Character tmpo;
						tmpo = (Character) operators.pop();
						postfix = postfix + tmpo.charValue();
						postfix = postfix + " ";
					}
					operators.push(tmp);
				}
			} else if (expression.charAt(i) == '(') {
				operators.push(tmp);
			} else if (expression.charAt(i) == ')') {
				Character paren = new Character('(');
				while (!operators.peek().equals(paren)) {
					Character tmpo;
					tmpo = (Character) operators.pop();
					postfix = postfix + tmpo.charValue();
					postfix = postfix + " ";
				}
				operators.pop();
			} else if (bool_a || bool_b || bool_c || bool_d) {
				postfix = postfix + expression.charAt(i);
				postfix = postfix + " ";
			} else {
				throw null;
			}

		}
		while (operators.size() > 0) {
			Character tmpo;
			tmpo = (Character) operators.pop();
			postfix = postfix + tmpo.charValue();
			if (operators.size() > 0) {
				postfix = postfix + " ";
			}
		}
		return postfix;
	}

	public int evaluate(String expression) {
		if (expression == "" || expression == null || expression == " ") {
			throw null;
		}
		Character plus = new Character('+');
		Character minus = new Character('-');
		Character mult = new Character('*');
		Character div = new Character('/');
		Stack operands = new Stack();
		for (int i = 0; i < expression.length(); i++) {
			boolean bool_b = expression.charAt(i) >= 'a'
					&& expression.charAt(i) <= 'z';
			boolean bool_c = expression.charAt(i) >= 'A'
					&& expression.charAt(i) <= 'Z';
			if (bool_b || bool_c) {
				throw null;
			}
			if (operands.size() > 100) {
				return 100244;
			}
			Character tmp = new Character(expression.charAt(i));

			if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
				Integer tmo = null;
				int b = Integer.parseInt(String.valueOf(tmp));
				tmo = Integer.valueOf(b);
				operands.push(tmo);
			} else if (tmp.equals(plus) || tmp.equals(minus)
					|| tmp.equals(mult) || tmp.equals(div)) {
				if (operands.size() < 2) {
					throw null;
				} else {
					Integer x = (Integer) operands.pop();
					int op_A = x.intValue();
					x = (Integer) operands.pop();
					int op_B = x.intValue();
					switch (expression.charAt(i)) {
					case '+':
						int res = op_A + op_B;
						x = Integer.valueOf(res);
						operands.push(x);
						break;
					case '-':
						int resu = op_B - op_A;
						x = Integer.valueOf(resu);
						operands.push(x);
						break;
					case '*':
						int re = op_A * op_B;
						x = Integer.valueOf(re);
						operands.push(x);
						break;
					case '/':
						int result = op_B / op_A;
						x = Integer.valueOf(result);
						operands.push(x);
						break;
					}
				}
			}
		}
		if (operands.size() == 1) {
			Integer finaly = (Integer) operands.pop();
			return finaly.intValue();
		} else if (operands.size() == 0) {
			throw null;
		}
		return 0;
	}

}
