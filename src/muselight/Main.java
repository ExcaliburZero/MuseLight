/*
 * Copyright (C) 2016 Shakhar Dasgupta<sdasgupt@oswego.edu>
 * Copyright (C) 2016 Christopher Wells <cwellsny@nycap.rr.com>
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

import musegestures.MuseGestureServer;
import musegestures.MuseGestures;

/**
 *
 * @author Shakhar Dasgupta<sdasgupt@oswego.edu>
 * @author Christopher Wells <cwellsny@nycap.rr.com>
 */
public class Main implements MuseGestures {

    private LightController lightController;

    public static void main(String[] args) {
        lightController = new LightController();
        new MuseGestureServer(this, 5000);
    }

    public void onBlink() {
        lightController.toggleGreen();
    }

    public void onJawClench() {
        lightController.toggleBlue();
    }
}
