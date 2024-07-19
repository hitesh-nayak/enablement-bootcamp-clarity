import ClayButton from '@clayui/button';
import ClayLink from '@clayui/link';
import ClayNavigationBar from '@clayui/navigation-bar';

import React, {useState} from 'react';
import Blog from './Blog';
import Documents from './Documents';
import Knowledge from './Knowledge';
import PromotionCategory from "./PromotionCategory";

const Navbar = () => {
	const [active, setActive] = useState('Item 4');

	return (
        <>
		<ClayNavigationBar triggerLabel={active}>
			<ClayNavigationBar.Item active={active === 'Item 1'}>
				<ClayLink
					href="#"
					onClick={(event) => {
						event.preventDefault();
						setActive('Item 1');
					}}
				>
					Blogs
				</ClayLink>
			</ClayNavigationBar.Item>
			<ClayNavigationBar.Item active={active === 'Item 2'}>
				<ClayButton
                    
					onClick={() => setActive('Item 2')}
				>
					Knowledge Base
				</ClayButton>
			</ClayNavigationBar.Item>
			<ClayNavigationBar.Item active={active === 'Item 3'}>
				<ClayLink
					href="#"
					onClick={(event) => {
						event.preventDefault();
						setActive('Item 3');
					}}
				>
					Documents
				</ClayLink>
			</ClayNavigationBar.Item>
			<ClayNavigationBar.Item active={active === 'Item 4'}>
				<ClayLink
					href="#"
					onClick={(event) => {
						event.preventDefault();
						setActive('Item 4');
					}}
				>
					Promotion
				</ClayLink>
			</ClayNavigationBar.Item>
		</ClayNavigationBar>

        {active ===`Item 1` && <Blog/>}
        {active ===`Item 2` && <Knowledge/>}
        {active ===`Item 3` && <Documents/>}
		{active ===`Item 4` && <PromotionCategory></PromotionCategory>}
        </>
	)
}

export default Navbar