function insertLinkIcons()
{
	// get an array of all the <a> tags in the document using the
	// standard DOM function getElementsByTagName.
   var aLinks = document.getElementsByTagName('a');
   var count = aLinks.length;

   // for each one of the <a> tags, get its href attribute
   // and see if it ends with ".pdf"
   for (var i = 0; i < count; i++) {
      var str = new String(aLinks[i].getAttribute('href'));

      // Note that this test only checks for links that end with ".pdf". A more advanced
      // test would take into account links that have parameters on them, like
      // ".pdf?arg1=val1", etc.
      if (str.lastIndexOf(".pdf",str.length) != -1)
      {
      	// if this <a> has a link to a PDF file, make a new <img> tag
      	// that points to our PDF file icon (you can substitute your
      	// own path to the image here, like "/images/icons/small_pdf_icon.gif")
         var image = document.createElement("img");
         image.setAttribute("src","small_pdf_icon.gif");
         image.setAttribute("align","absbottom");

         // insert the new IMG into the document right before the current
         // <a> tag. This is handled by asking whatever the parent tag of the
         // current <a> tag is to insert the new image in front of the <a>.
         // The standard DOM function insertBefore() does this: it takes
         // two arguments - the new element to insert, and the element you want
         // it inserted in front of.
         aLinks[i].parentNode.insertBefore(image,aLinks[i]);
      }
   }
}

com_joemarini.EVENTS.addEventHandler(window, "load", insertLinkIcons, false);
