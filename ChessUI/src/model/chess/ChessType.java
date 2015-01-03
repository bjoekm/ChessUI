package model.chess;

public enum ChessType {
	PAWN("pawn"),
	ROOK("rook"),
	KNIGHT("knight"),
	BISHOP("bishop"),
	KING("king"),
	QUEEN("queen"),
	NULL("null");
	
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
