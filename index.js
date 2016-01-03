import React from 'react-native';

const {requireNativeComponent, PropTypes, View, Component} = React;
const NativeSpinner = requireNativeComponent('SpinnerAndroid', Spinner);

class Spinner extends Component {
    constructor(context, props) {
        super(context, props);
        this._onChange = this._onChange.bind(this);
    }

    _onChange(event) {
        if (this.props.onChange) {
            this.props.onChange(event.nativeEvent);
        }
    }

    render() {
        return <NativeSpinner {...this.props} onChange={this._onChange}/>;
    }
}

Spinner.propTypes = Object.assign({}, View.propTypes, {
    values: PropTypes.array.isRequired,
    selected: PropTypes.number,
    onChange: PropTypes.func
});

Spinner.defaultProps = {
    values: [''],
    selected: 0
};

export default Spinner;