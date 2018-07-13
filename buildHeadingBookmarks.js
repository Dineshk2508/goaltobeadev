var g_cAnchorCount;
function buildBookmarks(strWhichTag, sBookMarkNode)
{
	var i;

	g_cAnchorCount = 0;
	
	// create the list that will hold the bookmark links
	var oList = document.createElement("UL");
	oList.setAttribute("id","bookmarksList");
	
	// now get a list of all the elements on the page that we want to create
	// bookmarks for. Typically these will be <h2>, <h3> tags, etc.
	var aMarkElements = document.getElementsByTagName(strWhichTag);
	// loop through each tag and make a bookmark for it
	for (i=0; i<aMarkElements.length;i++)
	{
		// get the text that is inside the given heading tag
		var sName = aMarkElements[i].firstChild.data;

		// build a named anchor for the location
		var oAnchor = buildNamedAnchor();
		// change the tag to be whatever it was but now fronted by the Anchor tag
		aMarkElements[i].innerHTML = oAnchor + aMarkElements[i].innerHTML;

		// create a LI tag for the bookmark. This will be inserted into our UL that 
		// holds all of the bookmarks.
		var oListItem = document.createElement("LI");
		var oLink = document.createElement("A");
		var sLinkDest = "#bookmark" + g_cAnchorCount;
		oLink.setAttribute("href", sLinkDest);

		// add the <a> tag to the LI
		oListItem.appendChild(oLink);
		var oLinkText = document.createTextNode(sName);
		oLink.appendChild(oLinkText);
		// now add the finished LI to the UL list
		oList.appendChild(oListItem);

		// increase the variable that's keeping track of how many named anchors
		// there are. This ensures that each one gets a unique name.
		g_cAnchorCount++;
	}
	// when we're finished, add the bookmark list to the end of the container
	// that will hold the bookmarks.
	insertBookmarkList(oList,sBookMarkNode);
}

function buildNamedAnchor()
{
	// create a named anchor of the form <a name='bookmarkX'><a/>
	// where X is an increasing integer number
    return "<A NAME='bookmark" + g_cAnchorCount + "'></A>";
}

// Inserts the bookmark list inside the given container tag 
// indicated by sBookmarkNode
function insertBookmarkList(oBookmarkList, sBookmarkNode)
{
	// get the tag to insert the bookmark list into
	var oListHost = document.getElementById(sBookmarkNode);
	// add the bookmark list
	oListHost.appendChild(oBookmarkList);
}
