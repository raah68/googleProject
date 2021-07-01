package com.google;

import javax.xml.transform.stream.StreamSource;
import java.nio.charset.Charset;
import java.util.*;

public class VideoPlayer {
  private ArrayList<Video> randomVideoList;
  private final VideoLibrary videoLibrary;


  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
    //this.vidList = this.videoLibrary.getVideos();
  }

  public void numberOfVideos() {
    System.out.println("%s videos in the library%n");
    //System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    System.out.println("Here's a list of all available videos:");
    //Create a local variable to store all videos
    List<Video> videoList = videoLibrary.getVideos();

    //Compare the last and first item in the array
    for(int i = 0; i < videoList.size()-1; ++i) {
      for (int j = i + 1; j < videoList.size(); ++j) {
        if (videoList.get(i).getTitle().compareTo(videoList.get(j).getTitle()) > 0) {
          Video temp = videoList.get(i);
          videoList.set(i, videoList.get(j));
          videoList.set(j, temp);
        }
      }
    }//end of loop iteration

    //Iterate through teh newly sorted list and print out title, id and tags of all vidoes
    for(Video v : videoList) {
      System.out.println(v.getTitle()+" ("+ v.getVideoId()+") "+v.getTags().toString().replace(",", ""));
    }
  }//end of method showAllVideos

  public void playVideo(String videoId) {
    String test = "hello";
    //find the video
    Video selectedVideo = videoLibrary.getVideo(videoId);
    //find the current playing video
    Video currentPlayingVideo = null;
    //Iterate through the videoLibrary to check if a video is already playing
    for(Video vid : videoLibrary.getVideos()){
      if(vid.getState()){
        currentPlayingVideo = vid;
      }
    }
    //Display text if conditions are a match
    if(selectedVideo == null){
      System.out.println("Cannot play video: Video does not exist");
    } else if(currentPlayingVideo != null && (currentPlayingVideo != selectedVideo)){
      videoLibrary.getVideo(selectedVideo.getVideoId()).setState(true);
      videoLibrary.getVideo(currentPlayingVideo.getVideoId()).setState(false);
      System.out.println("Stopping video: "+currentPlayingVideo.getTitle());
      System.out.println("Playing video: "+selectedVideo.getTitle());
    } else if(selectedVideo.getState()) {
      System.out.println("Stopping video: "+selectedVideo.getTitle());
      System.out.println("Playing video: "+selectedVideo.getTitle());
    } else {
      selectedVideo.setState(true);
      System.out.println("Playing video: "+selectedVideo.getTitle());
    }
  }//end of method

  public void stopVideo() {
    Video currentPlayingVideo = null;
    //Iterate through the videoLibrary to check if a video is already playing
    for(Video vid : videoLibrary.getVideos()){
      if(vid.getState()){
        currentPlayingVideo = vid;
      }
    }
    if(currentPlayingVideo != null){
      videoLibrary.getVideo(currentPlayingVideo.getVideoId()).setState(false);
      System.out.println("Stopping video: "+currentPlayingVideo.getTitle());
    } else {
      System.out.println("Cannot stop video: No video is currently playing");
    }

  }

  public void playRandomVideo() {
    addNewVideos();
    Video currentPlayingVideo = null;
    //Iterate through the videoLibrary to check if a video is already playing
    for(Video vid : videoLibrary.getVideos()){
      if(vid.getState()){
        currentPlayingVideo = vid;
      }
    }
    Random rand = new Random();
    Video randomVid = videoLibrary.getVideos().get(rand.nextInt(videoLibrary.getVideos().size()));

    if(currentPlayingVideo != null && currentPlayingVideo == randomVid){
      videoLibrary.getVideo(currentPlayingVideo.getVideoId()).setState(false);
      System.out.println("Stopping video: "+currentPlayingVideo.getTitle());
      videoLibrary.getVideo(randomVid.getVideoId()).setState(true);
      System.out.println("Playing video: "+randomVid.getTitle());
    } else {
      videoLibrary.getVideo(randomVid.getVideoId()).setState(true);
      System.out.println("Playing video: "+randomVid.getTitle());
    }
  }

  public void pauseVideo() {
    System.out.println("pauseVideo needs implementation");
  }

  public void continueVideo() {
    System.out.println("continueVideo needs implementation");
  }

  public void showPlaying() {
    System.out.println("showPlaying needs implementation");
  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }

  void addNewVideos(){
    ArrayList<String> tagList = new ArrayList<>();
    tagList.add("#google");
    tagList.add("#life");
    tagList.add("#career");
    videoLibrary.getVideos().add(new Video("Life at Google", "random_video_One", tagList));
    videoLibrary.getVideos().add(new Video("Living the Unit life", "random_video_two", tagList));
  }
}