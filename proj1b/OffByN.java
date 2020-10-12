public class OffByN implements CharacterComparator {
    int N;
    public OffByN (int n) {
        N = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        int abs = Math.abs(diff);
        return abs == N;
    }
}
