public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
       int diff = x - y;
       int abs = Math.abs(diff);
       return abs == 1;
    }

}
