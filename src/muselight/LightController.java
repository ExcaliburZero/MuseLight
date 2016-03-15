/*
 * Copyright (C) 2016 Shakhar Dasgupta<sdasgupt@oswego.edu>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package muselight;

/**
 *
 * @author Shakhar Dasgupta<sdasgupt@oswego.edu>
 */
public class LightController {

    private static final String PORT = "/dev/ttyS88";
    private static final byte RED_OFF = 0;
    private static final byte RED_ON = 1;
    private static final byte GREEN_OFF = 2;
    private static final byte GREEN_ON = 3;
    private static final byte BLUE_OFF = 4;
    private static final byte BLUE_ON = 5;

    private final SerialWriter serialWriter;
    private boolean redState;
    private boolean greenState;
    private boolean blueState;

    public LightController() {
        serialWriter = new SerialWriter(PORT);
        reset();
    }

    public void turnOffRed() {
        serialWriter.write(RED_OFF);
        redState = false;
    }

    public void turnOnRed() {
        serialWriter.write(RED_ON);
        redState = true;
    }

    public void turnOffGreen() {
        serialWriter.write(GREEN_OFF);
        greenState = false;
    }

    public void turnOnGreen() {
        serialWriter.write(GREEN_ON);
        greenState = true;
    }

    public void turnOffBlue() {
        serialWriter.write(BLUE_OFF);
        blueState = false;
    }

    public void turnOnBlue() {
        serialWriter.write(BLUE_ON);
        blueState = true;
    }

    public void reset() {
        turnOffRed();
        turnOffGreen();
        turnOffBlue();
    }

    public boolean getRedState() {
        return redState;
    }

    public boolean getGreenState() {
        return greenState;
    }

    public boolean getBlueState() {
        return blueState;
    }

    public void toggleRed() {
        if (redState) {
            turnOffRed();
        } else {
            turnOnRed();
        }
    }

    public void toggleGreen() {
        if (greenState) {
            turnOffGreen();
        } else {
            turnOnGreen();
        }
    }

    public void toggleBlue() {
        if (redState) {
            turnOffBlue();
        } else {
            turnOnBlue();
        }
    }
}
