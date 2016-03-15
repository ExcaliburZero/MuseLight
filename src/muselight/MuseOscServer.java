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

import oscP5.OscMessage;
import oscP5.OscP5;

/**
 *
 * @author Shakhar Dasgupta<sdasgupt@oswego.edu>
 */
public class MuseOscServer {

    private OscP5 osc;
    private boolean done;
    private LightController lightController;

    public MuseOscServer(int port) {
        osc = new OscP5(this, port);
        done = true;
        lightController = new LightController();
    }

    public void oscEvent(OscMessage msg) {
        if (msg.checkAddress("/muse/elements/blink")) {
            int value = msg.get(0).intValue();
            if (value == 1) {
                if (done) {
                    lightController.toggleGreen();
                    done = false;
                }
            } else {
                done = true;
            }
        } else if (msg.checkAddress("/muse/elements/jaw_clench")) {
            int value = msg.get(0).intValue();
            if (value == 1) {
                if (done) {
                    lightController.toggleBlue();
                    done = false;
                }
            } else {
                done = true;
            }
        }
    }
}
