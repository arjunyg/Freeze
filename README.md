Freeze
------

A simple Bukkit plugin to perform mass operations on the whitelist.

Currently the plugin is designed to compile and run with bukkit-1.6.4-R2.0.
Using a different version may cause it to malfunction.

Building
--------

The repository is set up such that if you put your bukkit jar named "bukkit-1.6.4-R2.0.jar" in the lib folder, everything will compile as it should.
If you wish to use a different version of bukkit, you can either delete the symbolic link (named bukkit.jar) from the lib folder and name your bukkit jar "bukkit.jar," or you could re-link "bukkit.jar" to your bukkit jar.

1. Download Bukkit from http://dl.bukkit.org/downloads/bukkit/list/rb/.
   (Use 1.6.4-R2.0 for best compatibility! - The project should still work with builds going back at least to minecraft version 1.2.5)

2. Move your download of bukkit to lib/bukkit.jar or create a link in lib called bukkit.jar that points to your copy of bukkit.

2. cd to the project directory.

3. Type 'make' to build the plugin.


Installation
------------

1. Move 'Freeze.jar' from the bin directory into the plugins folder of your bukkit server.


Command Usage
-------------

**/freeze [arguments ...]**


Arguments:

**addlimit:\<limit\>** - Randomly select the number of players specified by <limit> and add them to the whitelist.

**clear** - Clear the whitelist.

**enable** - Enable the whitelist.

**help** - Print this help message.

**save:\<name\>** - Save the current whitelist to disk with \<name\>.

**load:\<name\>** - Load a whitelist with \<name\> from the disk.

**list** - List the names of all the currently saved whitelists.

**delete:\<name\>** - Delete a whitelist save with name \<name\>.


Examples:

/freeze addlimit:30 enable - Add 30 players to the whitelist and make sure it is enabled.

/freeze clear - Clear the whitelist.

/freeze freeze - Add all online players to the whitelist.

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
