package eg.edu.alexu.csd.datastructure.linkedList.cs48;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class PolynomialSolver implements IPolynomialSolver {

	SinglyLL LLA = new SinglyLL();
	SinglyLL LLB = new SinglyLL();
	SinglyLL LLC = new SinglyLL();
	SinglyLL LLR = new SinglyLL();

	// ***************** Setting Polynomial *********************

	public void setPolynomial(char poly, int[][] res) {

		int power = 0;
		power = res[0][1];

		if (poly != 'A' && poly != 'B' && poly != 'C') {
			throw null;
		}

		for (int counter = 0; counter < res.length; counter++) {
			int[] temp = new int[2];
			temp[0] = res[counter][0];
			temp[1] = res[counter][1];
			if (temp[1] < 0) {
				throw null;
			}
			if (power - counter == temp[1]) {
				if (poly == 'A') {
					LLA.add(temp);
				} else if (poly == 'B') {
					LLB.add(temp);
				} else if (poly == 'C') {
					LLC.add(temp);
				}
			} else {
				throw new RuntimeException();
			}
		}
	}

	// ******************** Printing the Polynomial ******************

	public String print(char poly) {

		int size = 0;
		Node i = null;
		if (poly == 'A') {
			i = LLA.Head;
			size = LLA.size();
		} else if (poly == 'B') {
			i = LLB.Head;
			size = LLB.size();
		} else if (poly == 'C') {
			i = LLC.Head;
			size = LLC.size();
		} else if (poly == 'R') {
			i = LLR.Head;
			size = LLR.size();
		} else if (poly != 'R' && poly != 'A' && poly != 'B' && poly != 'C') {
			throw new RuntimeException();
		}
		if ((poly == 'A' && LLA.Head == null)
				|| (poly == 'B' && LLB.Head == null)
				|| (poly == 'C' && LLC.Head == null)
				|| (poly == 'R' && LLR.Head == null)) {
			return null;
		}

		String s = "", b = "", pos = "+";

		for (int counter = 0; counter < size; counter++) {
			int[] temp = new int[2];
			temp = (int[]) i.value;
			i = i.next;
			if (temp[0] != 0) {
				if (counter > 0) {
					if (temp[0] > 0) {
						b = b + pos;
					}
				}
				if ((temp[0] == 1 && temp[1] == 0)
						|| (temp[0] == -1 && temp[1] == 0)) {
					s = temp[0] + "";
				} else if (temp[0] == 1 && temp[1] == 1) {
					s = "x";
				} else if (temp[0] == -1 && temp[1] == 1) {
					s = "-x";
				} else if (temp[0] == 1) {
					s = "x^" + temp[1];
				} else if (temp[0] == -1) {
					s = "-x^" + temp[1];
				} else if (temp[1] == 0) {
					s = temp[0] + "";
				} else if (temp[1] == 1) {
					s = temp[0] + "x";
				} else {
					s = temp[0] + "x^" + temp[1];
				}
				b = b + s;
			}
		}

		return b;
	}

	public void clearPolynomial(char poly) {
		if (poly == 'A' && LLA.Head != null) {
			LLA.clear();
		} else if (poly == 'B' && LLB.Head != null) {
			LLB.clear();
		} else if (poly == 'C' && LLC.Head != null) {
			LLC.clear();
		} else if (poly == 'R' && LLR.Head != null) {
			LLR.clear();
		} else {
			throw null;
		}

	}

	public float evaluatePolynomial(char poly, float value) {

		SinglyLL list = null;

		if (poly != 'R' && poly != 'A' && poly != 'B' && poly != 'C') {
			throw new RuntimeException();
		} else if ((poly == 'A' && LLA.Head == null)
				|| (poly == 'B' && LLB.Head == null)
				|| (poly == 'C' && LLC.Head == null)
				|| (poly == 'R' && LLR.Head == null)) {
			throw new RuntimeException();
		}
		switch (poly) {
		case 'A':
			list = LLA;
			break;

		case 'B':
			list = LLB;
			break;

		case 'C':
			list = LLC;
			break;

		default:
			throw null;
		}

		int[] term = new int[2];

		float result = 0;
		for (int i = 0; i < list.size(); i++) {
			term = (int[]) list.get(i);
			int coef = term[0];
			int power = term[1];

			result += coef * Math.pow(value, power);
		}

		return result;
	}

	// ********************** ADDING POLYS ************************************
	public int[][] add(char poly1, char poly2) {
		// TODO Auto-generated method stub

		if ((poly1 == 'A' && LLA.Head == null)
				|| (poly1 == 'B' && LLB.Head == null)
				|| (poly1 == 'C' && LLC.Head == null)
				|| (poly1 == 'R' && LLR.Head == null)) {
			throw new RuntimeException();
		}

		if ((poly2 == 'A' && LLA.Head == null)
				|| (poly2 == 'B' && LLB.Head == null)
				|| (poly2 == 'C' && LLC.Head == null)
				|| (poly2 == 'R' && LLR.Head == null)) {
			throw new RuntimeException();
		}

		SinglyLL list1 = null;

		switch (poly1) {
		case 'A':
			list1 = LLA;
			break;

		case 'B':
			list1 = LLB;
			break;

		case 'C':
			list1 = LLC;
			break;

		default:
			throw null;
		}

		SinglyLL list2 = null;

		switch (poly2) {
		case 'A':
			list2 = LLA;
			break;

		case 'B':
			list2 = LLB;
			break;

		case 'C':
			list2 = LLC;
			break;

		default:
			throw null;
		}

		int[] TermL1 = new int[2];
		TermL1 = (int[]) list1.Head.value;

		int coefL1 = TermL1[0];
		int powerL1 = TermL1[1];

		int[] TermL2 = new int[2];
		TermL2 = (int[]) list2.Head.value;

		int coefL2 = TermL2[0];
		int powerL2 = TermL2[1];

		int size;
		int longer;

		if (powerL1 > powerL2) {
			size = powerL1 + 1;
			longer = 1;
		}

		else {
			size = powerL2 + 1;
			longer = 2;
		}

		int[] Arr1 = new int[powerL1 + 1];
		for (int i = 0; i < list1.size(); i++) {
			TermL1 = (int[]) list1.get(i);
			coefL1 = TermL1[0];
			powerL1 = TermL1[1];

			Arr1[powerL1] += coefL1;
		}

		int[] Arr2 = new int[powerL2 + 1];

		for (int j = 0; j < list2.size(); j++) {
			TermL2 = (int[]) list2.get(j);
			coefL2 = TermL2[0];
			powerL2 = TermL2[1];

			Arr2[powerL2] += coefL2;
		}

		int[] ArrResult = new int[size];

		int j = 0;

		if (longer == 1) {
			int i;
			for (i = 0; i < Arr2.length; i++) {
				ArrResult[j] = Arr1[i] + Arr2[i];
				j++;
			}

			for (i = Arr2.length; i < Arr1.length; i++) {
				ArrResult[j] = Arr1[i];
				j++;
			}
		}

		else if (longer == 2) {
			int i;
			for (i = 0; i < Arr1.length; i++) {
				ArrResult[j] = Arr1[i] + Arr2[i];
				j++;
			}

			for (; i < Arr2.length; i++) {
				ArrResult[j] = Arr2[i];
				j++;
			}
		}

		int RSize = 0;
		for (int i = size - 1; i >= 0; i--) {
			if (ArrResult[i] != 0)
				RSize++;
		}

		int[][] finalResult = new int[RSize][2];

		int z = 0;
		for (int i = size - 1; i >= 0; i--) {
			if (ArrResult[i] != 0) {
				finalResult[z][0] = ArrResult[i];
				finalResult[z][1] = i;
				z++;
			}
		}

		for (int counter = 0; counter < finalResult.length; counter++) {
			int[] temp = new int[2];
			temp[0] = finalResult[counter][0];
			temp[1] = finalResult[counter][1];
			LLR.add(temp);
		}

		return finalResult;
	}

	public int[][] subtract(char poly1, char poly2) {
		if (poly1 == poly2) {
			int[][] r = new int[1][2];
			r[0][0] = 0;
			r[0][1] = 0;
			return r;
		}
		// TODO Auto-generated method stub

		if ((poly1 == 'A' && LLA.Head == null)
				|| (poly1 == 'B' && LLB.Head == null)
				|| (poly1 == 'C' && LLC.Head == null)
				|| (poly1 == 'R' && LLR.Head == null)) {
			throw new RuntimeException();
		}

		if ((poly2 == 'A' && LLA.Head == null)
				|| (poly2 == 'B' && LLB.Head == null)
				|| (poly2 == 'C' && LLC.Head == null)
				|| (poly2 == 'R' && LLR.Head == null)) {
			throw new RuntimeException();
		}

		SinglyLL list1 = null;

		switch (poly1) {
		case 'A':
			list1 = LLA;
			break;

		case 'B':
			list1 = LLB;
			break;

		case 'C':
			list1 = LLC;
			break;

		default:
			throw null;
		}

		SinglyLL list2 = null;

		switch (poly2) {
		case 'A':
			list2 = LLA;
			break;

		case 'B':
			list2 = LLB;
			break;

		case 'C':
			list2 = LLC;
			break;

		default:
			throw null;
		}

		int[] TermL1 = new int[2];
		TermL1 = (int[]) list1.Head.value;

		int coefL1 = TermL1[0];
		int powerL1 = TermL1[1];

		int[] TermL2 = new int[2];
		TermL2 = (int[]) list2.Head.value;

		int coefL2 = TermL2[0];
		int powerL2 = TermL2[1];

		int size;
		int longer;

		if (powerL1 > powerL2) {
			size = powerL1 + 1;
			longer = 1;
		}

		else {
			size = powerL2 + 1;
			longer = 2;
		}

		int[] Arr1 = new int[powerL1 + 1];
		for (int i = 0; i < list1.size(); i++) {
			TermL1 = (int[]) list1.get(i);
			coefL1 = TermL1[0];
			powerL1 = TermL1[1];

			Arr1[powerL1] += coefL1;
		}

		int[] Arr2 = new int[powerL2 + 1];

		for (int j = 0; j < list2.size(); j++) {
			TermL2 = (int[]) list2.get(j);
			coefL2 = TermL2[0];
			powerL2 = TermL2[1];

			Arr2[powerL2] += coefL2;
		}

		int[] ArrResult = new int[size];

		int j = 0;

		if (longer == 1) {
			int i;
			for (i = 0; i < Arr2.length; i++) {
				ArrResult[j] = Arr1[i] - Arr2[i];
				j++;
			}

			for (i = Arr2.length; i < Arr1.length; i++) {
				ArrResult[j] = Arr1[i];
				j++;
			}
		}

		else if (longer == 2) {
			int i;
			for (i = 0; i < Arr1.length; i++) {
				ArrResult[j] = Arr1[i] - Arr2[i];
				j++;
			}

			for (; i < Arr2.length; i++) {
				ArrResult[j] = -Arr2[i];
				j++;
			}
		}

		int RSize = 0;
		for (int i = size - 1; i >= 0; i--) {
			if (ArrResult[i] != 0)
				RSize++;
		}

		int[][] finalResult = new int[RSize][2];

		int z = 0;
		for (int i = size - 1; i >= 0; i--) {
			if (ArrResult[i] != 0) {
				finalResult[z][0] = ArrResult[i];
				finalResult[z][1] = i;
				z++;
			}
		}

		for (int counter = 0; counter < finalResult.length; counter++) {
			int[] temp = new int[2];
			temp[0] = finalResult[counter][0];
			temp[1] = finalResult[counter][1];
			LLR.add(temp);
		}

		return finalResult;
	}

	public int[][] multiply(char poly1, char poly2) {

		SinglyLL list1 = null;

		switch (poly1) {
		case 'A':
			list1 = LLA;
			break;

		case 'B':
			list1 = LLB;
			break;

		case 'C':
			list1 = LLC;
			break;

		default:
			throw null;
		}

		SinglyLL list2 = null;

		switch (poly2) {
		case 'A':
			list2 = LLA;
			break;

		case 'B':
			list2 = LLB;
			break;

		case 'C':
			list2 = LLC;
			break;

		default:
			throw null;
		}

		int[] TermL1 = new int[2];
		TermL1 = (int[]) list1.Head.value;
		;
		int coefL1 = TermL1[0];
		int powerL1 = TermL1[1];

		int[] TermL2 = new int[2];
		TermL2 = (int[]) list2.Head.value;
		;
		int coefL2 = TermL2[0];
		int powerL2 = TermL2[1];

		int resultSize = powerL1 + powerL2 + 1;
		int[] result = new int[resultSize];

		for (int i = 0; i < list1.size(); i++) {
			TermL1 = (int[]) list1.get(i);
			coefL1 = TermL1[0];
			powerL1 = TermL1[1];

			for (int j = 0; j < list2.size(); j++) {
				TermL2 = (int[]) list2.get(j);
				coefL2 = TermL2[0];
				powerL2 = TermL2[1];

				result[(powerL1 + powerL2)] += coefL1 * coefL2;
			}
		}

		int RSize = 0;
		for (int i = resultSize - 1; i >= 0; i--) {
			if (result[i] != 0)
				RSize++;
		}

		int[][] finalResult = new int[RSize][2];

		int j = 0;
		for (int i = resultSize - 1; i >= 0; i--) {
			if (result[i] != 0) {
				finalResult[j][0] = result[i];
				finalResult[j][1] = i;
				j++;
			}

		}
		for (int counter = 0; counter < finalResult.length; counter++) {
			int[] temp = new int[2];
			temp[0] = finalResult[counter][0];
			temp[1] = finalResult[counter][1];
			LLR.add(temp);
		}
		return finalResult;
	}

}
