public class ObstacleTrack extends Obstacle implements Track {
    private int length;

    public ObstacleTrack(int length) {
        this.length = length;
    }

    public boolean runTrack(int maxRunDistance) {
        return length - maxRunDistance <= 0;
    }
}
