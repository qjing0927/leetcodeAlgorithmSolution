package imagehandler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import net.coobird.thumbnailator.Thumbnails;

public class CompressImages {
	public static void main(String... args) throws IOException {

		// CompressImages.compressImageIO();
		// CompressImages.compressThumbnail();
		CompressImages.commpressPicForScale("C:/Users/i325940/Documents/doc/test.gif",
				"C:/Users/i325940/Documents/doc/test3.gif", 500, 0.8);

	}

	/**
	 * specify size and accuracy to compress an image
	 * 
	 * @param srcPath
	 *            source file address JPEG, PNG, GIF, BMP and WBMP
	 * @param desPath
	 *            target file address
	 * @param desFilesize
	 *            specify image size in kb
	 * @param accuracy
	 *            accuracy , recurcively compress rates, suggest<0.9
	 * @return
	 */
	public static String commpressPicForScale(String srcPath, String desPath, long desFileSize, double accuracy) {
		if (srcPath.isEmpty() || srcPath.isEmpty()) {
			return null;
		}
		if (!new File(srcPath).exists()) {
			return null;
		}
		try {
			File srcFile = new File(srcPath);
			long srcFileSize = srcFile.length();
			System.out.println("source image：" + srcPath + ";size：" + srcFileSize / 1024 + "kb");

			// skip IOS 11 image format HEIF HEVC
			String[] fileSeperatedForExtentions = srcPath.split("\\.");
			String imageType = fileSeperatedForExtentions[fileSeperatedForExtentions.length - 1];

			if (imageType == "HEIF" || imageType == "HEVC" || imageType == "heif" || imageType == "hevc") {
				return null;
			}

			Thumbnails.of(srcPath).scale(1f).toFile(desPath);

			commpressPicCycle(desPath, desFileSize, accuracy);

			File desFile = new File(desPath);
			System.out.println("target image:" + desPath + "; size" + desFile.length() / 1024 + "kb");
			System.out.println("done！");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return desPath;
	}

	private static void commpressPicCycle(String desPath, long desFileSize, double accuracy) throws IOException {
		File srcFile = new File(desPath);
		long srcFileSize = srcFile.length();
		// if< target size
		if (srcFileSize <= desFileSize * 1024) {
			return;
		}
		// calculate width and height
		BufferedImage bim = ImageIO.read(srcFile);
		int srcWdith = bim.getWidth();
		int srcHeigth = bim.getHeight();
		int desWidth = new BigDecimal(srcWdith).multiply(new BigDecimal(accuracy)).intValue();
		int desHeight = new BigDecimal(srcHeigth).multiply(new BigDecimal(accuracy)).intValue();

		Thumbnails.of(desPath).size(desWidth, desHeight).outputQuality(accuracy).toFile(desPath);
		commpressPicCycle(desPath, desFileSize, accuracy);
	}

	public static void compressImageIO() throws IOException {
		File input = new File("C:/Users/i325940/Documents/doc/test.jpg");
		BufferedImage image = ImageIO.read(input);

		File output = new File("C:/Users/i325940/Documents/doc/testCom.jpg");
		OutputStream out = new FileOutputStream(output);

		ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
		ImageOutputStream ios = ImageIO.createImageOutputStream(out);
		writer.setOutput(ios);

		ImageWriteParam param = writer.getDefaultWriteParam();
		if (param.canWriteCompressed()) {
			param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			param.setCompressionQuality(0.05f);
		}

		writer.write(null, new IIOImage(image, null, null), param);

		out.close();
		ios.close();
		writer.dispose();
	}

	public static void compressThumbnail() throws IOException {
		Thumbnails.of(new File("C:/Users/i325940/Documents/doc/test.jpg")).outputQuality(0.5).size(500, 500)
				.toFile(new File("C:/Users/i325940/Documents/doc/testComThumb.jpg"));
	}
}
