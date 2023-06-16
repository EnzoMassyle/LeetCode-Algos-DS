class Solution {
    /**
    prompt: Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

    High Level Sol: 
        - start at rightmost character and find column number (Ex: A = 1, Z = 26)
        - move on to the next rightmost character, multiplying its column number value by (26 * current place in string)
        - keep going until all characters in string are explored

    TC: O(N), SC: O(1) where N represents the length of columnTitle
     */
    private final int CHARACTER_OFFSET = 64;
    public int titleToNumber(String columnTitle) { 
        int columnNumber = 0;
        int curSigFig = 1;
        int curIndex = columnTitle.length() - 1;
        while (curIndex >= 0) {
            columnNumber += ((int) columnTitle.charAt(curIndex) - CHARACTER_OFFSET) * curSigFig;
            curSigFig *= 26;
            curIndex--;
        }
        return columnNumber;
    }
}
