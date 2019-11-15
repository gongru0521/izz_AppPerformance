package com.test.demo;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.testng.annotations.Test;

import com.test.util.LogUtil;

public class ImageCompare {
	
	@Test
	public void testComparePic( ){
		
		String path1="D:\\testpics\\微信图片_20190910094241.jpg";
		
		String path2="D:\\testpics\\微信图片_20190910094241.jpg";
		
		ComparePartPic( path1,  path2);
		
		
	}

	
	public static double ComparePartPic(String path1, String path2) {
		
		
		
	
			
				return compareImage(path1, path2);
	
		
		
		
		
	}
	
	
	//返回照片相似率
	public static double compareImage(BufferedImage myImage, BufferedImage otherImage)  {
		
		
		double samePercent = 0;
		
		return samePercent;
		
		
		
		
		
	}
	
	//获取图片像素
	public static String[][] getPX(String args) {
		int[] rgb = new int[3];
		File file = new File(args);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinX();
		int miny = bi.getMinY();
		String[][] list = new String[width][height];
		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {
				int pixel = bi.getRGB(i, j);
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				list[i][j] = rgb[0] + "," + rgb[1] + "," + rgb[2];
			}
		}
		return list;
	}
	
	
	public static int compareImage(String imgPath1, String imgPath2) {
		String[] image={imgPath1,imgPath2};
		if(image.length==0){
			System.out.println("not image Files");
			System.exit(0);
			
		}
		
		String[][] arrayimage0 = getPX(image[0]);
		String[][] arrayimage1 = getPX(image[1]);
		
		int similarity=0;
		int unlike=0;
		
		int i = 0, j = 0;
		for (String[] strings : arrayimage0) {
			if ((i + 1) == arrayimage0.length) {
				continue;
			}
			for (int m = 0; m < strings.length; m++) {
				try {
					String[] value1 = arrayimage0[i][j].toString().split(",");
					String[] value2 = arrayimage1[i][j].toString().split(",");
					int k = 0;
					for (int n = 0; n < value2.length; n++) {
						if (Math.abs(Integer.parseInt(value1[k]) - Integer.parseInt(value2[k])) < 5) {
							similarity++;
						} else {
							unlike++;
						}
					}
				} catch (RuntimeException e) {
					continue;
				}
				j++;
			}
			i++;
		}
		arrayimage0 = getPX(image[1]);
		arrayimage1 = getPX(image[0]);
		i = 0;
		j = 0;
		for (String[] strings : arrayimage0) {
			if ((i + 1) == arrayimage0.length) {
				continue;
			}
			for (int m = 0; m < strings.length; m++) {
				try {
					String[] value1 = arrayimage0[i][j].toString().split(",");
					String[] value2 = arrayimage1[i][j].toString().split(",");
					int k = 0;
					for (int n = 0; n < value2.length; n++) {
						if (Math.abs(Integer.parseInt(value1[k]) - Integer.parseInt(value2[k])) < 5) {
							similarity++;
						} else {
							unlike++;
						}
					}
				} catch (RuntimeException e) {
					continue;
				}
				j++;
			}
			i++;
		}
		String baifen = "";
		try {
			baifen = ((Double.parseDouble(similarity + "") / Double.parseDouble((unlike + similarity) + "")) + "");
			baifen = baifen.substring(baifen.indexOf(".") + 1, baifen.indexOf(".") + 3);
		} catch (Exception e) {
			baifen = "0";
		}
		if (baifen.length() <= 0) {
			baifen = "0";
		}
		if (unlike == 0) {
			baifen = "100";
		}
		System.out.println("相似像素数量：" + similarity + " 不相似像素数量：" + unlike + " 相似率：" + Integer.parseInt(baifen) + "%");
		
		
		
		
		return Integer.parseInt(baifen);
	}
	
	
}
