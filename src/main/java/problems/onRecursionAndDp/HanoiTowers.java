package problems.onRecursionAndDp;

public class HanoiTowers {
    static void game(int n, char fromTower, char middleTower, char desitnationTower) {
        if (n == 1) {
            System.out.println("Move disc from Tower "+fromTower+" to Tower "+desitnationTower);
            return;
        }
        game(n - 1, fromTower, desitnationTower, middleTower);
        System.out.println("Move disc from Tower "+fromTower+" to Tower "+desitnationTower);

        game(n -1, middleTower, fromTower, desitnationTower);
    }

    public static void main(String[] args) {
        game(14, 'A', 'B', 'C');
    }
}
