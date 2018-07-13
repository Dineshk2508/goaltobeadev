if (!com_joemarini) var com_joemarini = {};
else if (com_joemarini && typeof(com_joemarini) != "object")
    throw new Error("com_joemarini is not an Object type");

com_joemarini.EVENTS = {
    NAME: "Event handling module",
    VERSION: 1.0,
    
    addEventHandler: function(oNode, sEvt, fnHandler, bCapture) {
        if (typeof (window.event) != "undefined")
            oNode.attachEvent("on" + sEvt, fnHandler);
        else
            oNode.addEventListener(sEvt, fnHandler, bCapture);
    },

    removeEventHandler: function(oNode, sEvt, fnHandler, bCapture) {
        if (typeof (window.event) != "undefined")
            oNode.attachEvent("on" + sEvt, fnHandler);
        else
            oNode.addEventListener(sEvt, fnHandler, bCapture);
    },

    getEventTarget: function(evt) {
        if (window.event) return window.event.srcElement;
        else return evt.target;
    },

    stopEvent: function(evt) {
        if (window.event) window.event.cancelBubble=true;
        else evt.stopPropagation();
    },
    
    preventDefault: function(evt) {
        if (window.event) window.event.returnValue=false;
        else evt.preventDefault();
    }
}
