package com.github.skjolber.ndef.utility;

import android.app.Activity;
import android.nfc.NfcAdapter;

import java.util.function.Supplier;

public class NfcFactory {

    protected final NfcAdapter adapter;
    protected final Supplier<Activity> activity;

    protected NfcForegroundDispatch nfcForegroundDispatch;
    protected NfcReaderCallback nfcReaderCallback;
    protected NfcSettings nfcSettings;

    public NfcFactory(NfcAdapter adapter, Supplier<Activity> activity) {
        this.adapter = adapter;
        this.activity = activity;
    }

    public NfcForegroundDispatchBuilder newForegroundDispatchBuilder() {
        return new NfcForegroundDispatchBuilder(this, adapter, activity);
    }

    public NfcReaderCallbackBuilder newReaderCallbackBuilder() {
        return new NfcReaderCallbackBuilder(this, adapter, activity);
    }

    public NfcSettingsBuilder newSettingsBuilder() {
        return new NfcSettingsBuilder(this, adapter, activity);
    }

    protected void setNfcForegroundDispatch(NfcForegroundDispatch nfcForegroundDispatch) {
        if(this.nfcForegroundDispatch != null) {
            throw new IllegalArgumentException("Already have foreground dispatch configured.");
        }

        this.nfcForegroundDispatch = nfcForegroundDispatch;
    }

    protected void setNfcReaderCallback(NfcReaderCallback nfcReaderCallback) {
        if(this.nfcReaderCallback != null) {
            throw new IllegalArgumentException("Already have reader callback configured.");
        }
        this.nfcReaderCallback = nfcReaderCallback;
    }

    protected void setNfcSettings(NfcSettings nfcSettings) {
        if(this.nfcSettings != null) {
            throw new IllegalArgumentException("Already have settings configured.");
        }
        this.nfcSettings = nfcSettings;
    }

    protected NfcReaderCallback getNfcReaderCallback() {
        return nfcReaderCallback;
    }

    protected NfcForegroundDispatch getNfcForegroundDispatch() {
        return nfcForegroundDispatch;
    }

    protected NfcSettings getNfcSettings() {
        return nfcSettings;
    }
}
