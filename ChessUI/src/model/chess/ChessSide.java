package model.chess;

public enum ChessSide {

	BLACK("black"),
	WHITE("white"), 
	EMPTY("empty"), 
	FORBIDDEN("forbidden");
	
	private final String text;

    /**
     * @param text
     */
    private ChessSide(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
	
}
