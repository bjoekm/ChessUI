package rules.chess;

public enum ChessType {
	PAWN("pawn"),
	ROOK("rook"),
	KNIGHT("knight"),
	BISHOP("bishop"),
	KING("king"),
	QUEEN("queen"), 
	EMPTY("empty"), 
	FORBIDDEN("forbidden");
	
	private final String text;

    /**
     * @param text
     */
    private ChessType(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
