import java.util.*;
public class Boardpath {
    public static ArrayList<String> getBoardPath(int curr, int end, int M) {
		if (curr == end) {
			ArrayList<String> baseres = new ArrayList<>();
			baseres.add("");
			return baseres;
		}
		ArrayList<String> myres = new ArrayList<>();
		for (int dice = 1; dice <= M && curr + dice <= end; dice++) {
			ArrayList<String> rr = getBoardPath(curr + dice, end, M);
			for (String val : rr) {
				myres.add(dice + val);
			}
		}
		return myres;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		ArrayList<String> ans = getBoardPath(0, a, b);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		System.out.println();
		System.out.println(ans.size());
	}
}
