class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      int original =image[sr][sc];
      if(original==color){
        return image;
      }
      dfs(image,sr,sc,original,color);
      return image;
    }
public void dfs(int[][] image,int sr,int sc,int original,int color){
  int n =image.length;
 int m =image[0].length;
 if(sr<0||sc<0||sr>=n||sc>=m){
    return;
 }
 if(image[sr][sc]!=original){
    return;
 }
 image[sr][sc]=color;
 dfs(image,sr-1,sc,original,color); //up
 dfs(image,sr+1,sc,original,color); //down
 dfs(image,sr,sc-1,original,color); //left
 dfs(image,sr,sc+1,original,color); //right
    }

}