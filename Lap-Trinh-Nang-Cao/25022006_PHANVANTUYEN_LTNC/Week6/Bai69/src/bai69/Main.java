package bai69;

interface AudioPlayable {
    void playAudio(String file);
}

interface VideoPlayable {
    void playVideo(String file);
}

class AudioPlayer implements AudioPlayable {
    @Override
    public void playAudio(String file) {
        System.out.println("Đang phát âm thanh: " + file);
    }
}

class VideoPlayer implements VideoPlayable {
    @Override
    public void playVideo(String file) {
        System.out.println("Đang phát video hình ảnh: " + file);
    }
}


class MediaPlayer {
    private AudioPlayable audioTool;
    private VideoPlayable videoTool;

    public MediaPlayer(AudioPlayable audioTool, VideoPlayable videoTool) {
        this.audioTool = audioTool;
        this.videoTool = videoTool;
    }

    public void playAudio(String file) {
        if (audioTool != null) {
            audioTool.playAudio(file);
        } else {
            System.out.println("Lỗi: Chưa lắp công cụ phát Audio!");
        }
    }

    public void playVideo(String file) {
        if (videoTool != null) {
            videoTool.playVideo(file);
        } else {
            System.out.println("Lỗi: Chưa lắp công cụ phát Video!");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        AudioPlayable myAudioPlayer = new AudioPlayer();
        VideoPlayable myVideoPlayer = new VideoPlayer();

        MediaPlayer systemPlayer = new MediaPlayer(myAudioPlayer, myVideoPlayer);

        System.out.println("\nKhách hàng yêu cầu mở nhạc:");
        systemPlayer.playAudio("SonTung_MTP_ChayNgayDi.mp3");

        System.out.println("\nKhách hàng yêu cầu mở phim:");
        systemPlayer.playVideo("Avengers_Endgame.mp4");
    }
}
