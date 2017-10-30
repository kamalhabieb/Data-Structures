package eg.edu.alexu.csd.datastructure.iceHockey.cs48;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class Tests {

	@Test
	public void testcase1() {
		PlayersFinder t1 = new PlayersFinder();
		String[] photo = { "33JUBU33", "3U3O4433", "O33P44NB", "PO3NSDP3",
				"VNDSD333", "OINFD33X" };
		int team = 3;
		int threshold = 16;
		Point[] result = t1.findPlayers(photo, team, threshold);
		Point[] ans = new Point[3];
		ans[0] = new Point(4, 5);
		ans[1] = new Point(13, 9);
		ans[2] = new Point(14, 2);
		for (int i = 0; i < 3; i++) {
			assertEquals(ans[i], result[i]);
		}
	}

	@Test
	public void testcase2() {
		PlayersFinder t2 = new PlayersFinder();
		String[] photo = { "44444H44S4", "K444K4L444", "4LJ44T44XH",
				"444O4VIF44", "44C4D4U444", "4V4Y4KB4M4", "G4W4HP4O4W",
				"4444ZDQ4S4", "4BR4Y4A444", "4G4V4T4444" };
		int team = 4;
		int threshold = 16;
		Point[] result = t2.findPlayers(photo, team, threshold);
		Point[] ans = new Point[6];
		ans[0] = new Point(3, 8);
		ans[1] = new Point(4, 16);
		ans[2] = new Point(5, 4);
		ans[3] = new Point(16, 3);
		ans[4] = new Point(16, 17);
		ans[5] = new Point(17, 9);
		for (int i = 0; i < 6; i++) {
			assertEquals(ans[i], result[i]);
		}
	}

	@Test
	public void testcase3() {
		PlayersFinder t3 = new PlayersFinder();
		String[] photo = { "8D88888J8L8E888", "88NKMG8N8E8JI88",
				"888NS8EU88HN8EO", "LUQ888A8TH8OIH8", "888QJ88R8SG88TY",
				"88ZQV88B88OUZ8O", "FQ88WF8Q8GG88B8", "8S888HGSB8FT8S8",
				"8MX88D88888T8K8", "8S8A88MGVDG8XK8", "M88S8B8I8M88J8N",
				"8W88X88ZT8KA8I8", "88SQGB8I8J88W88", "U88H8NI8CZB88B8",
				"8PK8H8T8888TQR8" };
		int team = 8;
		int threshold = 9;
		Point[] result = t3.findPlayers(photo, team, threshold);
		Point[] ans = new Point[19];
		ans[0] = new Point(1, 17);
		ans[1] = new Point(3, 3);
		ans[2] = new Point(3, 10);
		ans[3] = new Point(3, 25);
		ans[4] = new Point(5, 21);
		ans[5] = new Point(8, 17);
		ans[6] = new Point(9, 2);
		ans[7] = new Point(10, 9);
		ans[8] = new Point(12, 23);
		ans[9] = new Point(17, 16);
		ans[10] = new Point(18, 3);
		ans[11] = new Point(18, 11);
		ans[12] = new Point(18, 28);
		ans[13] = new Point(22, 20);
		ans[14] = new Point(23, 26);
		ans[15] = new Point(24, 15);
		ans[16] = new Point(27, 2);
		ans[17] = new Point(28, 26);
		ans[18] = new Point(29, 16);
		for (int i = 0; i < 19; i++) {
			assertEquals(ans[i], result[i]);
		}
	}

	@Test
	public void testcase4() {
		PlayersFinder t4 = new PlayersFinder();
		String[] photo = { "11111", "1AAA1", "1A1A1", "1AAA1", "11111" };
		int team = 1;
		int threshold = 3;
		Point[] result = t4.findPlayers(photo, team, threshold);
		Point[] ans = new Point[2];
		ans[0] = new Point(5, 5);
		ans[1] = new Point(5, 5);
		for (int i = 0; i < 2; i++) {
			assertEquals(ans[i], result[i]);
		}
	}

	@Test
	public void testcase5() {
		PlayersFinder t5 = new PlayersFinder();
		String[] photo = null;
		Point ans = null;
		int team = 8;
		int threshold = 9;
		Point[] result = t5.findPlayers(photo, team, threshold);
		assertEquals(ans, result);
	}

	@Test
	public void testcase6() {
		PlayersFinder t6 = new PlayersFinder();
		String[] photo = { "ASDFGGDFDFDF", "HKAFNJFADKF4", "AJFDFAFDFF44",
				"44SGDSGD4444", "44AFDFA4444A", "444AFHTJHK44", };
		int team = 4;
		int threshold = 12;
		Point[] result = t6.findPlayers(photo, team, threshold);
		Point[] ans = new Point[2];
		ans[0] = new Point(3, 9);
		ans[1] = new Point(19, 7);
		for (int i = 0; i < 2; i++) {
			assertEquals(ans[i], result[i]);
		}
	}

	@Test
	public void testcase7() {
		PlayersFinder t7 = new PlayersFinder();
		String[] photo = { "DNFKA1", "1FDAFF", "AFDF44", "KOUTG1", "11SDSD", };
		int team = 1;
		int threshold = 12;
		Point[] result = t7.findPlayers(photo, team, threshold);
		assertEquals(0, result.length);
	}

	@Test
	public void testcase8() {
		PlayersFinder t8 = new PlayersFinder();
		String[] photo = { "44444", "44444", "44444", "44444", "44444",
				"44444", };
		int team = 4;
		int threshold = 12;
		Point[] result = t8.findPlayers(photo, team, threshold);
		Point ans = new Point();
		ans = new Point(5, 6);
		assertEquals(ans, result[0]);
	}

	@Test
	public void testcase9() {
		PlayersFinder t9 = new PlayersFinder();
		String[] photo = { "ASFDGADFAF", "FADGSFHFAG", "DAFSGDHFFD",
				"QWERTYUYTE", "JIBDBFSLKF", "AFSGDFSHGF", "SDAFSGDHFJ",
				"SDFGDGHDGG" };
		int team = 4;
		int threshold = 12;
		Point[] result = t9.findPlayers(photo, team, threshold);
		assertEquals(0, result.length);
	}

	@Test
	public void testcase10() {
		PlayersFinder t10 = new PlayersFinder();
		String[] photo = { "4B4DD", "4H4F4", "WQ4A4", "4Y4f4", "4G44A",
				"4D444", };
		int team = 4;
		int threshold = 5;
		Point[] result = t10.findPlayers(photo, team, threshold);
		Point[] ans = new Point[4];
		ans[0] = new Point(1, 2);
		ans[1] = new Point(1, 9);
		ans[2] = new Point(7, 6);
		ans[3] = new Point(9, 5);

		for (int i = 0; i < 4; i++) {
			assertEquals(ans[i], result[i]);
		}
	}

	@Test
	public void testcase11() {
		PlayersFinder t11 = new PlayersFinder();
		String[] photo = { "DNFKLA7777777ADASDS77FD",
				"ADSDASFA77FADGDAG777ASF", };
		int team = 7;
		int threshold = 8;
		Point[] result = t11.findPlayers(photo, team, threshold);
		Point[] ans = new Point[2];
		ans[0] = new Point(19, 2);
		ans[1] = new Point(38, 2);
		for (int i = 0; i < 2; i++) {
			assertEquals(ans[i], result[i]);
		}
	}

	@Test
	public void testcase12() {
		PlayersFinder t6 = new PlayersFinder();
		String[] photo = { "JABD9XC999DDD9999F99FGF",
				"F99K9S9DJ9S99D9L9N99G9G", "9D9K9N99DD9A9KSDNASJ9SD",
				"9AS99NSJ99AKJ9999DN9KDD", "9B99DSADJANSDJANSDJ99DD",
				"9DASDJBKSAD9K99DN9DC9AA", "SDFADGSF9D9S99GDF9FSAD9",
				"99SFA99DGS9GAFGGF9SDAS9", "9ASDF99D9A9A9GADAFD99S9",
				"9J9SNFJANA9KNFDJN9D9VC9", "F999J9N99FNAUC99KNN9SD9",
				"9G99BNF99NV9DMK99QDID9D", "9S9999JFNADJVNADJKN99JC",
				"9A9ANS9JANDVJSNVJ9NV99J", "9ASD9SF9A9SNKDCNAM99MS9",
				"9DNG9999F999NSFDJGNF999" };
		int team = 9;
		int threshold = 16;
		Point[] result = t6.findPlayers(photo, team, threshold);
		Point[] ans = new Point[21];
		ans[0] = new Point(1, 9);
		ans[1] = new Point(1, 27);
		ans[2] = new Point(2, 17);
		ans[3] = new Point(7, 5);
		ans[4] = new Point(7, 23);
		ans[5] = new Point(12, 16);
		ans[6] = new Point(12, 30);
		ans[7] = new Point(16, 22);
		ans[8] = new Point(17, 2);
		ans[9] = new Point(21, 16);
		ans[10] = new Point(21, 30);
		ans[11] = new Point(27, 12);
		ans[12] = new Point(30, 2);
		ans[13] = new Point(30, 7);
		ans[14] = new Point(31, 22);
		ans[15] = new Point(38, 2);
		ans[16] = new Point(40, 9);
		ans[17] = new Point(40, 19);
		ans[18] = new Point(41, 26);
		ans[19] = new Point(43, 30);
		ans[20] = new Point(45, 17);

		for (int i = 0; i < 21; i++) {
			assertEquals(ans[i], result[i]);
		}
	}

	@Test
	public void testcase13() {
		PlayersFinder t8 = new PlayersFinder();
		String[] photo = {};
		int team = 4;
		int threshold = 12;
		Point[] result = t8.findPlayers(photo, team, threshold);
		assertEquals(0, result.length);
	}

}