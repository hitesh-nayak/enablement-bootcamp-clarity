import ClayButton from '@clayui/button';
import ClayLink from '@clayui/link';
import ClayNavigationBar from '@clayui/navigation-bar';

import React, {useState} from 'react';
import DigitusCNDNForm from "./DigitusCNDNForm";

const Navbar = () => {
	const [active, setActive] = useState('Item 4');

	return (
        <>
		<ClayNavigationBar triggerLabel={active}>
			<ClayNavigationBar.Item active={active === 'Item 4'}>
				<ClayLink
					href="#"
					onClick={(event) => {
						event.preventDefault();
						setActive('Item 4');
					}}
				>
					Digitus CNDN
				</ClayLink>
			</ClayNavigationBar.Item>
		</ClayNavigationBar>

		{active ===`Item 4` && <DigitusCNDNForm></DigitusCNDNForm>}
        </>
	)
}

export default Navbar