package graphics;
import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

import model.chess.ChessSide;
import model.chess.ChessType;

public final class ImageFactory {

	
	public static final String RESOURCE_PATH = "/";
	
	private HashMap<String, Image > imagePool;
	private static ImageFactory instance = null;
	
	private ImageFactory(){
		imagePool = new HashMap<String, Image >();
	}
	
	public ImageFactory getInstance(){
		if(instance == null){
			instance = new ImageFactory();
		}
		return instance;
	}
	
	public Image getChessPieceImage(ChessType ct, ChessSide cs){
		String fileEnding = ".png";
		String resolution = "50px";
		String getStr =  cs.getText() + "_" + ct.getText() +"_"+resolution+fileEnding;
		
		return getImageFromPool(getStr);
	}	
	
	public Image getImageFromPool(String str){
		str = ImageFactory.RESOURCE_PATH+str;
		Image objFromPool = imagePool.get(str);
		if(objFromPool == null){
			try{
				objFromPool = new ImageIcon(this.getClass().getClassLoader().getResource(str)).getImage();
				imagePool.put(str, objFromPool);
			}catch (NullPointerException e){
				//Log this
				String errStr = "ImageFactory error - couldn't find path: " + str;
				System.out.println(errStr);
				objFromPool = new SimpleImage(40,40);
			}
		}
		return objFromPool;
	}
}


