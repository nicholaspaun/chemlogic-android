package ca.nicholaspaun.chemlogic.app1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class CompounderFragment extends ChemlogicFragment {

	private ChemlogicController ctrl;
	
	public CompounderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_compounder, container,
				false);
		
		
		setup_keyboard(rootView);
		keyboard_focus(rootView,true);
		
		setup_submit(rootView);
		setup_spinner(rootView,R.id.compounder_type_input,R.array.compounder_type_array);
		ctrl = ((MainActivity) getActivity()).getController();
		return rootView;
	}
	
	
	public void submit(View v)
	{
    	Spinner inputTypeSpinner =  (Spinner) getActivity().findViewById(R.id.compounder_type_input);
    	String  inputType = inputTypeSpinner.getSelectedItem().toString().toLowerCase();
    	
    	
    	EditText inputEdit = (EditText) getActivity().findViewById(R.id.chemlogic_input);
        String input = inputEdit.getText().toString();
        
        String output = ctrl.command(inputType, input);

        TextView outputView = (TextView) getActivity().findViewById(R.id.chemlogic_output);
        outputView.setText(Html.fromHtml(output));
        
        defocus(inputEdit);
 }
	
	
}