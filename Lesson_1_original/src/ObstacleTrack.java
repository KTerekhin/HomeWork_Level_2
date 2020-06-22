public class ObstacleTrack extends Obstacle {
    private int length;

    public ObstacleTrack(int length) {
        this.length = length;
    }

    public boolean runTrack(int RunDistance) {
        return length - RunDistance <= 0;
    }
}