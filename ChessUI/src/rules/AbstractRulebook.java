package rules;

import java.awt.Point;

public abstract class AbstractRulebook {

	abstract boolean checkMove(Piece p, Point newPos);

}
