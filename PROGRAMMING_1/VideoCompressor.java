public class VideoCompressor {

    private static double videoSize = 150;  // Size in MB, initially set to 150MB

    public static void main(String[] args) {
        while (videoSize > 100) {
            compressVideo();
            System.out.println("Compressed video to " + videoSize + "MB");
        }
    }

    public static void compressVideo() {
        // Simulating compression by reducing the video size by 10%
        videoSize = videoSize * 0.9;
    }
}
