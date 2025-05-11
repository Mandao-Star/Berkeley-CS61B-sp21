package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHeroLite {
    public static final double CONCERT_A = 440.0;
    public static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    //模拟钢琴键盘布局，包含 白键（字母键）和 黑键（数字和符号键）
    private static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private  static final GuitarString[] strings = new GuitarString[KEYBOARD.length()];

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        GuitarString stringA = new GuitarString(CONCERT_A);
        GuitarString stringC = new GuitarString(CONCERT_C);

        //初始化吉他弦
        for(int i = 0; i < KEYBOARD.length(); i++){
            double frequency = 440.0 * Math.pow(2, (i - 24) / 12.0);
            strings[i] = new GuitarString(frequency);
        }


        while (true) {

            /* check if the user has typed a key; if so, process it */
            //按键检测与处理
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();

                int index = KEYBOARD.indexOf(key);

                if(index != -1){
                    strings[index].pluck();
                }
            }

            //声音合成与播放
            double sample = 0.0;
            for(GuitarString string : strings){
                sample += string.sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
//            stringA.tic();
//            stringC.tic();

            //更新弦状态
            for(GuitarString string : strings){
                string.tic();
            }
        }
    }
}

