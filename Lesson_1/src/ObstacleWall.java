public class ObstacleWall extends Obstacle implements Wall {
    private int height;

    public ObstacleWall(int height) {
        this.height = height;
    }

    public boolean jumpWall(int maxJumpHeight) {
        return height - maxJumpHeight <= 0;
    }
}
