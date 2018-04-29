import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;


public class ExpansionImage{
	public static void main(String args[]){

		int width;
		int height;

		int exp; // �g�嗦

		BufferedImage img;

		if(args.length != 2){
			System.out.println("�g�p���@: java ExpansionImage [�x�[�X�摜(�g���q�t��)] [�{��(int)]");
			return;
		}

		String base_file_name = args[0];

		// ��{�̉摜��ǂݍ���
		BufferedImage base_img;
		try {
			File base_file = new File(System.getProperty("user.dir") + "/" + base_file_name);
			base_img = ImageIO.read(base_file);
		} catch(IOException e) {
			e.printStackTrace();
			return;
		}

		// �{����int�ɕϊ�
		try {
			exp = Integer.parseInt(args[1]);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			return;
		}

		int base_width = base_img.getWidth();
		int base_height = base_img.getHeight();
			
		width = base_width * exp;
		height = base_height * exp;
			
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			
		int base_color;
		for(int i = 0; i < base_width; i++) {
			for(int j = 0; j < base_height; j++) {
				base_color = base_img.getRGB(i, j);
				
				for(int l = 0; l < exp; l++){
					for(int n = 0; n < exp; n++){
						img.setRGB(i * exp + n, j * exp + l, base_color);
					}
				}
				
			}
		}
		try{
			ImageIO.write(img, "png", new File(System.getProperty("user.dir") + "/result.png"));
		}catch(IOException e){
			e.printStackTrace();
			return;
		}
		System.out.println("�������������܂���");
	}
}