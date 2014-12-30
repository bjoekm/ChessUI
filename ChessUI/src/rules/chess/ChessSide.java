package rules.chess;

public enum ChessSide {

	BLACK("black"),
	WHITE("white"), 
	NEUTRAL("neutral");
	
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
