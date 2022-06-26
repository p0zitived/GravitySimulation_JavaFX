package Utils;

import MainClasses.Global;

public class PhysicsCalculation extends Thread {
    private boolean stop = false;
    private boolean pause = false;
    private int fps = 1;

    @Override
    public void run() {
        while(!stop) {
            if (!pause) {
                for (Space_object obj : Global.objects_list) {
                    obj.setGravity_vect();

                    obj.getObject().setCenterX(obj.getObject().getCenterX() + obj.getMove_dir().x);
                    obj.getObject().setCenterY(obj.getObject().getCenterY() + obj.getMove_dir().y);
                }
            }

            try {
                Thread.sleep(1000/fps);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }
    public void close() {
        this.stop = true;
    }
    public void setFps(int fps) {
        this.fps = fps;
    }
    public int getFps() {
        return fps;
    }
}
