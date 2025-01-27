# Volatility
# Copyright (C) 2008 Volatile Systems
#
# This program is free software; you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation; either version 2 of the License, or (at
# your option) any later version.
#
# This program is distributed in the hope that it will be useful, but
# WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
# General Public License for more details. 
#
# You should have received a copy of the GNU General Public License
# along with this program; if not, write to the Free Software
# Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA 
#

# Blocksize was chosen to make it aligned
# on 8 bytes
# Optimized by Michael Cohen

import os, sys

VERSION = "2.0"

SCAN_BLOCKSIZE = 1024 * 1024 * 10

PLUGINPATH = os.path.dirname(__file__)
# If we're in a pyinstaller executable 
if hasattr(sys, "frozen"):
    try:
        import iu, _mountzlib #pylint: disable=W0611,F0401
        PLUGINPATH = os.environ["_MEIPASS2"]
    except ImportError:
        pass
PLUGINPATH = os.path.join(PLUGINPATH, 'plugins')
