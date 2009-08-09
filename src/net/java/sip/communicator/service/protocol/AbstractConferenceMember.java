/*
 * SIP Communicator, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package net.java.sip.communicator.service.protocol;

import net.java.sip.communicator.util.*;

/**
 * Provides the default implementation of the <code>ConferenceMember</code>
 * interface.
 * 
 * @author Lubomir Marinov
 */
public class AbstractConferenceMember
    extends PropertyChangeNotifier
    implements ConferenceMember
{

    /**
     * The <code>CallParticipant</code> which is the conference focus of this
     * <code>ConferenceMember</code>.
     */
    private final CallPeer conferenceFocusCallParticipant;

    /**
     * The user-friendly display name of this <code>ConferenceMember</code> in
     * the conference.
     */
    private String displayName;

    /**
     * The state of the device and signaling session of this
     * <code>ConferenceMember</code> in the conference.
     */
    private ConferenceMemberState state = ConferenceMemberState.UNKNOWN;

    public AbstractConferenceMember(
        CallPeer conferenceFocusCallParticipant)
    {
        this.conferenceFocusCallParticipant = conferenceFocusCallParticipant;
    }

    /*
     * Implements ConferenceMember#getConferenceFocusCallParticipant().
     */
    public CallPeer getConferenceFocusCallParticipant()
    {
        return conferenceFocusCallParticipant;
    }

    /*
     * Implement ConferenceMember#getDisplayName().
     */
    public String getDisplayName()
    {
        return displayName;
    }

    /*
     * Implements ConferenceMember#getState().
     */
    public ConferenceMemberState getState()
    {
        return state;
    }

    /**
     * Sets the user-friendly display name of this <code>ConferenceMember</code>
     * in the conference and fires a new <code>PropertyChangeEvent</code> for
     * the property <code>#DISPLAY_NAME_PROPERTY_NAME</code>.
     * 
     * @param displayName
     *            the user-friendly display name of this
     *            <code>ConferenceMember</code> in the conference
     */
    public void setDisplayName(String displayName)
    {
        if (((this.displayName == null) && (displayName != null))
                || ((this.displayName != null)
                        && !this.displayName.equals(displayName)))
        {
            String oldValue = this.displayName;

            this.displayName = displayName;

            firePropertyChange(
                DISPLAY_NAME_PROPERTY_NAME,
                oldValue,
                this.displayName);
        }
    }

    /**
     * Sets the state of the device and signaling session of this
     * <code>ConferenceMember</code> in the conference and fires a new
     * <code>PropertyChangeEvent</code> for the property
     * <code>#STATE_PROPERTY_NAME</code>.
     * 
     * @param state
     *            the state of the device and signaling session of this
     *            <code>ConferenceMember</code> in the conference
     */
    public void setState(ConferenceMemberState state)
    {
        if (this.state != state)
        {
            ConferenceMemberState oldValue = this.state;

            this.state = state;

            firePropertyChange(STATE_PROPERTY_NAME, oldValue, this.state);
        }
    }
}
