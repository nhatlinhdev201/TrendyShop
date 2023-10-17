package testFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URISyntaxException;
import java.net.URL;

public class ImageUploader extends JFrame {

	private JButton selectImageBtn;
	private JButton saveImageBtn;
	private JButton viewImageBtn;
	private JLabel imageLabel;
	private File selectedImage;
	private File savedImage;
	private String absolutePath;
	private String relativePath;

	public ImageUploader(String absolutePath, String relativePath) throws HeadlessException {
		super();
		this.absolutePath = absolutePath;
		this.relativePath = relativePath;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public ImageUploader() {
		setTitle("Image Uploader");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLayout(new BorderLayout());

		selectImageBtn = new JButton("Chọn ảnh");
		saveImageBtn = new JButton("Lưu");
		viewImageBtn = new JButton("Xem hình");

		imageLabel = new JLabel();
		imageLabel.setHorizontalAlignment(JLabel.CENTER);

		selectImageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedImage = fileChooser.getSelectedFile();
					try {
						Image img = ImageIO.read(selectedImage);
						imageLabel.setIcon(new ImageIcon(img));
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		saveImageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedImage != null) {
					try {
						URL imageUrl = getClass().getResource("/images/");
						if (imageUrl != null) {
							File imagesFolder = new File(imageUrl.toURI());
							if (!imagesFolder.exists()) {
								imagesFolder.mkdirs();
							}

							String newName = "nv-avt." + getFileExtension(selectedImage.getName());
							savedImage = new File(imagesFolder, newName);
							ImageIO.write(ImageIO.read(selectedImage), getFileExtension(selectedImage.getName()),
									savedImage);
							JOptionPane.showMessageDialog(null,
									"Hình ảnh đã được lưu tại: " + savedImage.getAbsolutePath());
							absolutePath = savedImage.getAbsolutePath();
							System.out.println("path image save : " + absolutePath);
							viewImageBtn.setEnabled(true);
						}
					} catch (IOException | URISyntaxException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		viewImageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (savedImage != null) {
					try {
						BufferedImage img = ImageIO.read(savedImage);
						JFrame viewerFrame = new JFrame();
						viewerFrame.setTitle("Hình ảnh đã lưu");
						viewerFrame.setSize(400, 400);
						viewerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						viewerFrame.setLayout(new BorderLayout());
						JLabel viewerLabel = new JLabel(new ImageIcon(img));
						viewerLabel.setHorizontalAlignment(JLabel.CENTER);
						viewerFrame.add(viewerLabel, BorderLayout.CENTER);
						viewerFrame.setVisible(true);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(selectImageBtn);
		buttonPanel.add(saveImageBtn);
		buttonPanel.add(viewImageBtn);
		viewImageBtn.setEnabled(false);

		add(buttonPanel, BorderLayout.NORTH);
		add(imageLabel, BorderLayout.CENTER);
	}

	private String getFileExtension(String filename) {
		int dotIndex = filename.lastIndexOf(".");
		if (dotIndex > 0) {
			return filename.substring(dotIndex + 1);
		}
		return "";
	}

	public String extractPath(String fullPath) {
		// Tìm vị trí của chuỗi "\images" trong đường dẫn
		int index = fullPath.indexOf("\\images");

		// Kiểm tra xem có tìm thấy "\images" hay không
		if (index != -1) {
			// Trích xuất phần ký tự bắt đầu từ "\images" trở đi
			String extractedPath = fullPath.substring(index);

			return extractedPath;
		}

		// Trả về null nếu không tìm thấy "\images" trong đường dẫn
		return null;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			ImageUploader frame = new ImageUploader();
			frame.setVisible(true);
		});
	}
}
