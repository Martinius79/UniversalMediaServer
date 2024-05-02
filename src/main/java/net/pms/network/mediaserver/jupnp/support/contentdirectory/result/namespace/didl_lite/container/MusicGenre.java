/*
 * This file is part of Universal Media Server, based on PS3 Media Server.
 *
 * This program is a free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; version 2 of the License only.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package net.pms.network.mediaserver.jupnp.support.contentdirectory.result.namespace.didl_lite.container;

import net.pms.network.mediaserver.jupnp.support.contentdirectory.result.namespace.didl_lite.DIDL_LITE;
import net.pms.network.mediaserver.jupnp.support.contentdirectory.result.namespace.upnp.UPNP;

/**
 * A musicGenre instance is a genre which is interpreted as a style of music.
 *
 * A musicGenre container can contain objects of class musicArtist, musicAlbum,
 * audioItem or sub-musicgenres of the same class (for example, Rock contains
 * Alternative Rock). The classes of objects a musicGenre container may actually
 * contain is device-dependent. This class is derived from the genre class and
 * inherits the properties defined by that class.
 */
public class MusicGenre extends GenreContainer {

	private static final UPNP.Class CLASS = new UPNP.Class(DIDL_LITE.OBJECT_CONTAINER_GENRE_MUSICGENRE_TYPE);

	public MusicGenre() {
		setUpnpClass(CLASS);
	}

	public MusicGenre(Container other) {
		super(other);
		setUpnpClass(CLASS);
	}

	public MusicGenre(String id, Container parent, String title, String creator, Long childCount) {
		this(id, parent.getId(), title, creator, childCount);
	}

	public MusicGenre(String id, String parentID, String title, String creator, Long childCount) {
		super(id, parentID, title, creator, childCount);
		setUpnpClass(CLASS);
	}

}
