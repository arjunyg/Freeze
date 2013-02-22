Freeze
------

A simple Bukkit plugin to perform mass operations on the whitelist.

Currently the plugin is designed to compile and run with bukkit-1.4.7-R1.0.
Using a different version may cause it to malfunction.

Building
--------

1. Download Bukkit from http://dl.bukkit.org/downloads/bukkit/list/rb/.
   (Use 1.4.7-R1.0 for best compatibility! - The project should still work with builds going back at least to minecraft version 1.2.5)

2. Move your download of bukkit to lib/bukkit.jar or create a link in lib called bukkit.jar that points to your copy of bukkit.

2. cd to the project directory.

3. Type 'make' to build the plugin.


Installation
------------

1. Move 'Freeze.jar' from the bin directory into the plugins folder of your bukkit server.


Command Usage
-------------

/freeze [arguments ...]

Arguments:

**e**  Make sure the whitelist is enabled. If it is off, turn it on, then proceed to add players as normal.
**p<limit>** Sets a limit on the number of players that can be added.
**c** Clears the whitelist.

Examples:

/freeze p30 e : Add 30 players to the whitelist and make sure it is enabled.

/freeze c : Clear the whitelist.

/freeze : Add all online players to the whitelist.

License
-------

Copyright (C) 2012 Arjun Govindjee

Ths program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

Contact
-------

You can contact the original developer of the Freeze plugin by email at **arjunyg@gmail.com**.
